package com.example.SpotifyApi.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Album;
import com.example.SpotifyApi.model.Artist;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Repository
public class AlbumRepositoryImpl implements AlbumRepository {
	private HashMap<String, Album> albums = new HashMap<>();
	
	private String filePath;
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
		Month currentMonth = LocalDate.now().getMonth();//Getting the current month
	    File folder = new File("src/main/resources/albumCSV");
	    String[] listOfFiles = folder.list();
	    
	    for (String name : listOfFiles) {
	    	try {
	    	String date = name.split("album-")[1].split(".csv")[0];
	    	LocalDate date1 = LocalDate.parse(date);
	    	if (currentMonth.getValue() == date1.getMonthValue()){
	    		HeaderColumnNameMappingStrategy<Album> ms = new HeaderColumnNameMappingStrategy<>();
	    		ms.setType(Album.class);
	    		CsvToBean<Album> bean = new CsvToBeanBuilder<Album>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
	    		List<Album> list = bean.parse();
		    	for( Album artist : list ) {
		    		albums.put(artist.getId(), artist);
		    	}
	    	}
	    }
		    catch(Exception e) {
		    System.out.println("Ignoring");
		    }
	    }
	}


	public void setAllParameters() throws IOException {
		Collection<Album> albumCollection = albums.values();
		Writer fw = new FileWriter(filePath);
        StatefulBeanToCsv<Album> sbc = new StatefulBeanToCsvBuilder<Album>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

        try {
			sbc.write(albumCollection.stream());
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        fw.close();
}



public AlbumRepositoryImpl() throws IOException {
	try {
		
		LocalDate.now().toString();
		String fileDate = "album-" + LocalDate.now().toString();
		ClassPathResource csvResoursePath = new ClassPathResource("albumCSV/" + fileDate + ".csv");
		//csvResoursePath.getFile();
		filePath = "src/main/resources/" + csvResoursePath.getPath();
		if (csvResoursePath.exists()) {
			readCsvToHashMap();
		}
		else {
			File createFile = new File("src/main/resources/" + csvResoursePath.getPath());
			createFile.createNewFile();
			CSVWriter csvWrite = new CSVWriter(new FileWriter(createFile));
			String[] entries = {"id","name","date"};
			csvWrite.writeNext(entries);
			csvWrite.close();

		}
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}


	public Album addAlbum(Album albumtModel) throws IOException {
	
		albums.put(albumtModel.getId(), albumtModel);
		setAllParameters();
		return albumtModel;
	
	}
	
	
	
	@Override
	public ArrayList<Album> getAllAlbums() {
		ArrayList<Album> list = new ArrayList<>(albums.values());
		return list;
	}

	@Override
	public Album getAlbum(String id) {
		return albums.get(id);
	}

	@Override
	public void updateAlbum(String id, Album albumEntity) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAlbum(String id) throws IOException {
		albums.remove(id);
		
		if (!albums.isEmpty()) {
		
			setAllParameters();
		}
		else {
			CSVWriter csvWrite = new CSVWriter(new FileWriter(filePath));
			String[] entries = {"id","name","age","artistLabel"};
			csvWrite.writeNext(entries);
			csvWrite.close();
		}
	}

}
