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
//	private void readCsvToHashMap(String fileFolderName, String fileEntityName, Class modelClassName) throws IllegalStateException, IOException{
//		
//		Month currentMonth = LocalDate.now().getMonth();//Getting the current month
//	    File folder = new File("src/main/resources/" + fileFolderName);
//	    String[] listOfFiles = folder.list();
//	    
//	    for (String name : listOfFiles) {
//	    	try {
//	    	String date = name.split(fileEntityName + "-")[1].split(".csv")[0];
//	    	LocalDate date1 = LocalDate.parse(date);
//	    	if (currentMonth.getValue() == date1.getMonthValue()){
//	    		HeaderColumnNameMappingStrategy<modelClassName> ms = new HeaderColumnNameMappingStrategy<>();
//	    		ms.setType(modelClassName.class);
//	    		CsvToBean<modelClassName> bean = new CsvToBeanBuilder<modelClassName>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
//	    		List<modelClassName> list = bean.parse();
//		    	for( modelClassName artist : list ) {
//		    		artists.put(artist.getId(), artist);
//		    	}
//	    	}
//	    }
//		    catch(Exception e) {
//		    System.out.println("Ignoring");
//		    }
//	    }
//	}
//
//}

