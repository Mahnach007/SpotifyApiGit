package com.example.SpotifyApi.servise;

import java.io.IOException;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.model.Label;
import com.example.SpotifyApi.repository.ArtistRepository;
import com.example.SpotifyApi.repository.LabelRepository;

@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelRepository labelRepository;

	private long idCounter = 1L;

	@Override
	public Label createLabel(Label label) {
		label.setId(idCounter++);
		labelRepository.addLabel(label);
		return label;
	}

	@Override
	public ArrayList<Label> getAllLabels() {
		return labelRepository.getAllLabels();
	}

	@Override
	public Label getLabel(long id) {
		return labelRepository.getLabel(id);
	}

	@Override
	public Boolean updateLabel(long id, Label label) {

		Boolean ifExist = false;

		try {
			ifExist = labelRepository.updateLabel(id, label);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

	@Override
	public Boolean deleteLabel(long id) {

		Boolean ifExist = false;
		try {
			ifExist = labelRepository.deleteLabel(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}
}
