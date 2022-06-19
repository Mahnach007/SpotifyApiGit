package com.example.SpotifyApi.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
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

@Repository
public class ArtistRepositoryImpl implements ArtistRepository{
	private HashMap<String, Artist> artists = new HashMap<>();
	
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
			Month currentMonth = LocalDate.now().getMonth();//Getting the current month
		    File folder = new File("/Users/Vlad/eclipse-workspace/SpotifyApi/SpotifyApiGit/src/main/resources/artistCSV");
		    String[] listOfFiles = folder.list();
		    for (String name : listOfFiles) {
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

	}
	
	
	public ArtistRepositoryImpl() throws IOException {
		try {
			
			LocalDate.now().toString();
			String fileDate = "artist-" + LocalDate.now().toString();
			File file = new ClassPathResource("artistCSV/" + fileDate + ".csv").getFile();
		
			if (file.exists()) {
				readCsvToHashMap();
			}
			else {
				CSVWriter csvWrite = new CSVWriter(new FileWriter(file));
				String[] entries = {"id","name","age","artistLabel"};
				csvWrite.writeNext(entries);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
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
	public Artist addArtist(Artist artistModel) {
		if (artists != null){
			
		}
		return artistModel;
		
	}
	public void deleteArtist(String id){
		artists.remove(id);
		
	}

	public void updateArtist(String id, ArtistEntity artistEntity) {
		// TODO Auto-generated method stub
		
	}
	
	
}
