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


import com.example.SpotifyApi.model.Song;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Repository	
public class SongRepositoryImpl implements SongRepository {

private HashMap<String, Song> songs = new HashMap<>();
	
	private String filePath;
	
	
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
			Month currentMonth = LocalDate.now().getMonth();//Getting the current month
		    File folder = new File("src/main/resources/songCSV");
		    String[] listOfFiles = folder.list();
		    
		    for (String name : listOfFiles) {
		    	try {
		    	String date = name.split("song-")[1].split(".csv")[0];
		    	LocalDate date1 = LocalDate.parse(date);
		    	if (currentMonth.getValue() == date1.getMonthValue()){
		    		HeaderColumnNameMappingStrategy<Song> ms = new HeaderColumnNameMappingStrategy<>();
		    		ms.setType(Song.class);
		    		CsvToBean<Song> bean = new CsvToBeanBuilder<Song>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
		    		List<Song> list = bean.parse();
			    	for( Song song : list ) {
			    		songs.put(song.getId(), song);
			    	}
		    	}
		    }
			    catch(Exception e) {
			    System.out.println("Ignoring");
			    }
		    }
		}
	
	
	public void setAllParameters() throws IOException {
			Collection<Song> artistsCollection = songs.values();
			Writer fw = new FileWriter(filePath);
	        StatefulBeanToCsv<Song> sbc = new StatefulBeanToCsvBuilder<Song>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

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

	
	
	public SongRepositoryImpl() throws IOException {
		try {
			
			LocalDate.now().toString();
			String fileDate = "song-" + LocalDate.now().toString();
			ClassPathResource csvResoursePath = new ClassPathResource("songCSV/" + fileDate + ".csv");
			filePath = "src/main/resources/" + csvResoursePath.getPath();
			if (csvResoursePath.exists()) {
				readCsvToHashMap();
			}
			else {
				File createFile = new File("src/main/resources/" + csvResoursePath.getPath());
				createFile.createNewFile();
				CSVWriter csvWrite = new CSVWriter(new FileWriter(createFile));
				String[] entries = {"id","name","date","artist"};
				csvWrite.writeNext(entries);
				csvWrite.close();

			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Song addSong(Song songModel) throws IOException {
		
		songs.put(songModel.getId(), songModel);
	setAllParameters();
	return songModel;
	
	}
	
	
	@Override
	public ArrayList<Song> getAllSongs() {
		ArrayList<Song> list = new ArrayList<>(songs.values());
		return list;
	}

	@Override
	public Song getSong(String id) {
		return songs.get(id);
	}

	@Override
	public void updateSong(String id, Song lableEntity) throws IOException {
		songs.put(id , lableEntity);

		setAllParameters();
	}

	@Override
	public void deleteSong(String id) throws IOException {
		songs.remove(id);
		
		if (!songs.isEmpty()) {
		
			setAllParameters();
		}
		else {
			CSVWriter csvWrite = new CSVWriter(new FileWriter(filePath));
			String[] entries = {"id","name","date","artist"};
			csvWrite.writeNext(entries);
			csvWrite.close();
		}
		
		
	}

}
