package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Label;

@Repository
public class LabelRepositoryImpl extends BaseCSVRepository<Label> implements LabelRepository {

	public LabelRepositoryImpl() throws IOException {
		super("label", new String[] { "id", "name", "date", "labelCreator" } );
		
	}

	@Override
	public ArrayList<Label> getAllLabels() {
		recreateDataSourceIfNewDay();
		ArrayList<Label> list = new ArrayList<>(entities.values());
		return list;
	}

	@Override
	public Label getLabel(long id) {
		recreateDataSourceIfNewDay();
		return entities.get(id);
	}

	@Override
	public Label addLabel(Label label) {
		recreateDataSourceIfNewDay();

		entities.put(label.getId(), label);
		try {
			saveToCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return label;

	}

	@Override
	public Boolean deleteLabel(long id) {
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
	public Boolean updateLabel(long id, Label lable) {
		recreateDataSourceIfNewDay();

		if (entities.containsKey(id)) {

			entities.put(id, lable);
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
