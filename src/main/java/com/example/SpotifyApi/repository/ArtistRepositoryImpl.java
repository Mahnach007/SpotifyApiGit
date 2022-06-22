package com.example.SpotifyApi.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;



import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.entities.ArtistEntity;

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
public class ArtistRepositoryImpl implements ArtistRepository{
	private HashMap<String, Artist> artists = new HashMap<>();
	
	private String filePath;
	
	
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
			Month currentMonth = LocalDate.now().getMonth();//Getting the current month
		    File folder = new File("src/main/resources/artistCSV");
		    String[] listOfFiles = folder.list();
		    
		    for (String name : listOfFiles) {
		    	try {
		    	String date = name.split("artist-")[1].split(".csv")[0];
		    	LocalDate date1 = LocalDate.parse(date);
		    	if (currentMonth.getValue() == date1.getMonthValue()){
		    		HeaderColumnNameMappingStrategy<Artist> ms = new HeaderColumnNameMappingStrategy<>();
		    		ms.setType(Artist.class);
		    		CsvToBean<Artist> bean = new CsvToBeanBuilder<Artist>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
		    		List<Artist> list = bean.parse();
			    	for( Artist artist : list ) {
			    		artists.put(artist.getId(), artist);
			    	}
		    	}
		    }
			    catch(Exception e) {
			    System.out.println("Ignoring");
			    }
		    }
		}
	
	
	public void setAllParameters() throws IOException {
			Collection<Artist> artistsCollection = artists.values();
			Writer fw = new FileWriter(filePath);
	        StatefulBeanToCsv<Artist> sbc = new StatefulBeanToCsvBuilder<Artist>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

	        try {
				sbc.write(artistsCollection.stream());
			} catch (CsvDataTypeMismatchException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (CsvRequiredFieldEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        fw.close();
	}

	
	
	public ArtistRepositoryImpl() throws IOException {
		try {
			
			LocalDate.now().toString();
			String fileDate = "artist-" + LocalDate.now().toString();
			ClassPathResource csvResoursePath = new ClassPathResource("artistCSV/" + fileDate + ".csv");
			//csvResoursePath.getFile();
			filePath = "src/main/resources/" + csvResoursePath.getPath();
			if (csvResoursePath.exists()) {
				readCsvToHashMap();
			}
			else {
				File createFile = new File("src/main/resources/" + csvResoursePath.getPath());
				createFile.createNewFile();
				CSVWriter csvWrite = new CSVWriter(new FileWriter(createFile));
				String[] entries = {"id","name","age","artistLabel"};
				csvWrite.writeNext(entries);
				csvWrite.close();

			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Artist> getAllArtists() {
		ArrayList<Artist> list = new ArrayList<>(artists.values());
		return list;
	}
	public Artist getArtist(String id) {
		return artists.get(id);
		
	}
	
	public Artist addArtist(Artist artistModel) throws IOException {
		
		artists.put(artistModel.getId(), artistModel);
		setAllParameters();
		return artistModel;
		
	}
	public void deleteArtist(String id) throws IOException{
		artists.remove(id);
		
		if (!artists.isEmpty()) {
		
			setAllParameters();
		}
		else {
			CSVWriter csvWrite = new CSVWriter(new FileWriter(filePath));
			String[] entries = {"id","name","age","artistLabel"};
			csvWrite.writeNext(entries);
			csvWrite.close();
		}
	
		
	}

	public void updateArtist(String id, Artist artist) throws IOException {
		
		artists.put(id , artist);

		setAllParameters();

//		Collection<Artist> artistsCollection = artists.values();
//		
//        Writer fw = new FileWriter(filePath);
//        StatefulBeanToCsv<Artist> sbc = new StatefulBeanToCsvBuilder<Artist>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();
//
//        try {
//			sbc.write(artistsCollection.stream());
//		} catch (CsvDataTypeMismatchException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (CsvRequiredFieldEmptyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        fw.close();
		
		
	}



	
	
}
