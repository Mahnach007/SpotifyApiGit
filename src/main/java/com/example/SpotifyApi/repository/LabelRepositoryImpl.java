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

import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.model.Label;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class LabelRepositoryImpl implements LabelRepository{

	
private HashMap<String, Label> labels = new HashMap<>();
	
	private String filePath;
	
	
	
	private void readCsvToHashMap() throws IllegalStateException, IOException{
		
			Month currentMonth = LocalDate.now().getMonth();//Getting the current month
		    File folder = new File("src/main/resources/labelCSV");
		    String[] listOfFiles = folder.list();
		    
		    for (String name : listOfFiles) {
		    	try {
		    	String date = name.split("label-")[1].split(".csv")[0];
		    	LocalDate date1 = LocalDate.parse(date);
		    	if (currentMonth.getValue() == date1.getMonthValue()){
		    		HeaderColumnNameMappingStrategy<Label> ms = new HeaderColumnNameMappingStrategy<>();
		    		ms.setType(Label.class);
		    		CsvToBean<Label> bean = new CsvToBeanBuilder<Label>(new FileReader(folder.getPath() + "/" + name)).withMappingStrategy(ms).withIgnoreLeadingWhiteSpace(true).build();
		    		List<Label> list = bean.parse();
			    	for( Label artist : list ) {
			    		labels.put(artist.getId(), artist);
			    	}
		    	}
		    }
			    catch(Exception e) {
			    System.out.println("Ignoring");
			    }
		    }
		}
	
	
	public void setAllParameters() throws IOException {
			Collection<Label> artistsCollection = labels.values();
			Writer fw = new FileWriter(filePath);
	        StatefulBeanToCsv<Label> sbc = new StatefulBeanToCsvBuilder<Label>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR).build();

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

	
	
	public LabelRepositoryImpl() throws IOException {
		try {
			
			LocalDate.now().toString();
			String fileDate = "lable-" + LocalDate.now().toString();
			ClassPathResource csvResoursePath = new ClassPathResource("labelCSV/" + fileDate + ".csv");
			//csvResoursePath.getFile();
			filePath = "src/main/resources/" + csvResoursePath.getPath();
			if (csvResoursePath.exists()) {
				readCsvToHashMap();
			}
			else {
				File createFile = new File("src/main/resources/" + csvResoursePath.getPath());
				createFile.createNewFile();
				CSVWriter csvWrite = new CSVWriter(new FileWriter(createFile));
				String[] entries = {"id","name","date","labelCreator"};
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
	public ArrayList<Label> getAllLabels() {
		ArrayList<Label> list = new ArrayList<>(labels.values());
		return list;
	}

	@Override
	public Label getLabel(String id) {
		return labels.get(id);
	}

	@Override
	public void updateLabel(String id, Label lableEntity) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLabel(String id) throws IOException {
		labels.remove(id);
		
		if (!labels.isEmpty()) {
		
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
