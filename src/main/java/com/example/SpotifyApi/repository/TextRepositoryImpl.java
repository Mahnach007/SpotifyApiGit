package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Text;

@Repository
public class TextRepositoryImpl extends BaseCSVRepository<Text> implements TextRepository {

	public TextRepositoryImpl() throws IOException {
		super( "text",new String[] { "id", "name", "lyrics" } );
	
	}

	@Override
	public ArrayList<Text> getAllTexts() {
		recreateDataSourceIfNewDay();
		ArrayList<Text> list = new ArrayList<>(entities.values());
		return list;
	}

	@Override
	public Text getText(long id) {
		recreateDataSourceIfNewDay();
		return entities.get(id);
	}

	@Override
	public Text addText(Text text) {

		recreateDataSourceIfNewDay();

		entities.put(text.getId(), text);
		try {
			saveToCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return text;

	}

	@Override
	public Boolean deleteText(long id) {
		recreateDataSourceIfNewDay();

		if (!entities.containsKey(id)) {
			return false;

		}

		entities.remove(id);
		if (!entities.isEmpty()) {

			try {
				saveToCSV();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			writeCSVHeadersToFile(filePath);

		}
		return true;
	}

	@Override
	public Boolean updateText(long id, Text text) {
		recreateDataSourceIfNewDay();

		if (entities.containsKey(id)) {

			entities.put(id, text);
			try {
				saveToCSV();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}
}
