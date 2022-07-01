package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Text;
import ua.lviv.iot.spotifyapi.repository.TextRepository;

@Service
public class TextServiceImpl implements TextService {

	@Autowired
	private TextRepository textRepository;

	private long idCounter = 1L;

	@PostConstruct
	public void init() {
		idCounter = textRepository.getLastEntityId();
	}
	@Override
	public Text createText(Text Text) {
		Text.setId(++idCounter);
		textRepository.addText(Text);
		return Text;
	}

	@Override
	public ArrayList<Text> getAllTexts() {
		return textRepository.getAllTexts();
	}

	@Override
	public Text getText(long id) {
		return textRepository.getText(id);
	}

	@Override
	public Boolean updateText(long id, Text text) {

		Boolean ifExist = false;

		try {
			ifExist = textRepository.updateText(id, text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

	@Override
	public Boolean deleteText(long id) {

		Boolean ifExist = false;
		try {
			ifExist = textRepository.deleteText(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

}
