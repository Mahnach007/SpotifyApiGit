package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Text;

@Repository
public interface TextRepository {
	 Text addText(Text text);

	 ArrayList<Text> getAllTexts();

	 Text getText(long id);

	 Boolean updateText(long id, Text text) throws IOException;

	 Boolean deleteText(long id) throws IOException;
	 
	 long getLastEntityId();
}
