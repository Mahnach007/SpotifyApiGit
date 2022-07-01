package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;


import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Label;
import ua.lviv.iot.spotifyapi.repository.LabelRepository;

@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelRepository labelRepository;

	private long idCounter = 1L;
	
	@PostConstruct
	public void init() {
		idCounter = labelRepository.getLastEntityId();
	}

	@Override
	public Label createLabel(Label label) {
		label.setId(++idCounter);
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
