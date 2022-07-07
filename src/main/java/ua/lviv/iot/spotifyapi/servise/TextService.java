package ua.lviv.iot.spotifyapi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Text;

@Service
public interface TextService {
	Text createText(Text text);

	ArrayList<Text> getAllTexts();

	Text getText(long id);

	Boolean updateText(long id, Text text);

	Boolean deleteText(long id);
}
