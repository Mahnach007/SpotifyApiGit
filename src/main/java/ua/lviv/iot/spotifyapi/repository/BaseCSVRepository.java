package ua.lviv.iot.spotifyapi.repository;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import ua.lviv.iot.spotifyapi.model.BaseModel;

public abstract class BaseCSVRepository<T extends BaseModel> {
	protected HashMap<Long, T> entities = new HashMap<>();

	protected String filePath;
	protected String updateDate;
	private String entityName;
	private String[] entityHeaders;
	private Class<T> enityClass;

	final private String filesFolderPath = "src/main/resources/csvFiles/";

	public BaseCSVRepository(String newEntityName, String[] newEntityHeaders, Class<T> newEnityClass)
			throws IOException {
		entityName = newEntityName;
		entityHeaders = newEntityHeaders;
		enityClass = newEnityClass;

		try {
			if (!createFile(LocalDate.now().toString())) {
				readCSV();
			} else {
				writeCSVHeadersToFile(filePath);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public long getLastEntityId() {
		if (entities.isEmpty()) {
			return 0;
		}
		return Collections.max(entities.keySet());
	}

	private void readCSV() throws IllegalStateException, IOException {
		HeaderColumnNameMappingStrategy<T> ms = new HeaderColumnNameMappingStrategy<>();
		ms.setType(enityClass);
		String upToDateFilePath = String.format("%s%s-%s.csv", filesFolderPath, entityName, updateDate);
		CsvToBean<T> bean = new CsvToBeanBuilder<T>(new FileReader(upToDateFilePath)).withMappingStrategy(ms)
				.withIgnoreLeadingWhiteSpace(true).build();
		List<T> list = bean.parse();
		for (T entity : list) {
			entities.put(entity.getId(), entity);
		}
	}

	protected void saveToCSV() throws IOException {
		Collection<T> entitiesCollection = entities.values();

		Writer fw = new FileWriter(filePath);
		StatefulBeanToCsv<T> sbc = new StatefulBeanToCsvBuilder<T>(fw).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
				.build();

		try {
			sbc.write(entitiesCollection.stream());
		} catch (CsvDataTypeMismatchException e) {
			e.printStackTrace();
		} catch (CsvRequiredFieldEmptyException e) {
			e.printStackTrace();
		}
		fw.close();
	}

	private Boolean createFile(String date) throws IOException {
		updateDate = date;
		String fileDate = String.format("%s-%s", entityName, updateDate);
		File file = new File(String.format("%s%s.csv", filesFolderPath, fileDate));
		filePath = file.getPath();
		return file.createNewFile();
	}

	protected void createCSV(String date) throws IOException {
		createFile(date);
		writeCSVHeadersToFile(filePath);
	}

	protected void writeCSVHeadersToFile(String path) {
		try {
			CSVWriter csvWrite = new CSVWriter(new FileWriter(path));
			csvWrite.writeNext(entityHeaders);
			csvWrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void recreateDataSourceIfNewDay() {
		String currentDate = LocalDate.now().toString();
		if (!updateDate.equals(currentDate)) {
			try {

				createCSV(currentDate);

			} catch (IOException e) {
				e.printStackTrace();
			}
			entities.clear();

		}

	}

}
