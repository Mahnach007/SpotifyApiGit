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
import com.example.SpotifyApi.model.Text;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Repository	
public class TextRepositoryImpl  implements TextRepository{
	private HashMap<String, Text> texts = new HashMap<>();
	
	private String filePath;
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
		Month currentMonth = LocalDate.now().getMonth();//Getting the current month
	    File folder = new File("src/main/resources/textCSV");
	    String[] listOfFiles = folder.list();
	    
	    for (String name : listOfFiles) {
	    	try {
	    	String date = name.split("text-")[1].split(".csv")[0];
	    	LocalDate date1 = LocalDate.parse(date);
	    	if (currentMonth.getValue() == date1.getMonthValue()){
	    		HeaderColumnNameMappingStrategy<Text> ms = new HeaderColumnNameMappingStrategy<>();
	    		ms.setType(Text.class);
	    		CsvToBean<Text> bean = new CsvToBeanBuilder<Text>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
	    		List<Text> list = bean.parse();
		    	for( Text text : list ) {
		    		texts.put(text.getId(), text);
		    	}
	    	}
	    }
		    catch(Exception e) {
		    System.out.println("Ignoring");
		    }
	    }
	}


public void setAllParameters() throws IOException {
		Collection<Text> textCollection = texts.values();
		Writer fw = new FileWriter(filePath);
        StatefulBeanToCsv<Text> sbc = new StatefulBeanToCsvBuilder<Text>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

        try {
			sbc.write(textCollection.stream());
		} catch (CsvDataTypeMismatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        fw.close();
}



public TextRepositoryImpl() throws IOException {
	try {
		
		LocalDate.now().toString();
		String fileDate = "text-" + LocalDate.now().toString();
		ClassPathResource csvResoursePath = new ClassPathResource("textCSV/" + fileDate + ".csv");
		filePath = "src/main/resources/" + csvResoursePath.getPath();
		if (csvResoursePath.exists()) {
			readCsvToHashMap();
		}
		else {
			File createFile = new File("src/main/resources/" + csvResoursePath.getPath());
			createFile.createNewFile();
			CSVWriter csvWrite = new CSVWriter(new FileWriter(createFile));
			String[] entries = {"id","name","lyrics"};
			csvWrite.writeNext(entries);
			csvWrite.close();

		}
	} catch (IllegalStateException e) {
		e.printStackTrace();
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
}
	
	
	
	@Override
	public ArrayList<Text> getAllTexts() {
		ArrayList<Text> list = new ArrayList<>(texts.values());
		return list;
	}

	@Override
	public Text getText(String id) {
		return texts.get(id);
	}

	@Override
	public void updateText(String id, Text textEntity) throws IOException {
		texts.put(id , textEntity);

		setAllParameters();
		
	}

	@Override
	public void deleteText(String id) throws IOException {
		texts.remove(id);
		
		if (!texts.isEmpty()) {
		
			setAllParameters();
		}
		else {
			CSVWriter csvWrite = new CSVWriter(new FileWriter(filePath));
			String[] entries = {"id","name","lyrics"};
			csvWrite.writeNext(entries);
			csvWrite.close();
		}
		
	}

}
