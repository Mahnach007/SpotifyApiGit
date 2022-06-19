//package com.example.SpotifyApi.repository;
//
//import java.io.File;
//import java.io.FileReader;
//import java.io.IOException;
//import java.time.LocalDate;
//import java.time.Month;
//import java.util.HashMap;
//import java.util.List;
//
//import com.example.SpotifyApi.model.Artist;
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.opencsv.bean.HeaderColumnNameMappingStrategy;
//
//public abstract class BaseCSVRepository {
//	
//	private void readCsvToHashMap(Entity entity) throws IllegalStateException, IOException{
//		
//		Month currentMonth = LocalDate.now().getMonth();//Getting the current month
//	    File folder = new File("/Users/Vlad/eclipse-workspace/SpotifyApi/SpotifyApiGit/src/main/resources/artistCSV");
//	    String[] listOfFiles = folder.list();
//	    for (String name : listOfFiles) {
//	    	String date = name.split("artist-")[1].split(".csv")[0];
//	    	LocalDate date1 = LocalDate.parse(date);
//	    	if (currentMonth.getValue() == date1.getMonthValue()){
//	    		HeaderColumnNameMappingStrategy<Artist> ms = new HeaderColumnNameMappingStrategy<>();
//	    		ms.setType(Artist.class);
//	    		CsvToBean<Artist> bean = new CsvToBeanBuilder<Artist>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
//	    		List<Artist> list = bean.parse();
//	    		for( Artist artist : list ) {
//	    
//	    	        artists.put(artist.getId(), artist);
//	    	    }
//	    	}
//	
//	    }
//
//}
//}
