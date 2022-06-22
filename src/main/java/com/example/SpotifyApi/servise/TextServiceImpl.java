package com.example.SpotifyApi.servise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.SongResponse;
import com.example.SpotifyApi.Payload.TextResponse;
import com.example.SpotifyApi.entities.SongEntity;
import com.example.SpotifyApi.entities.TextEntity;
import com.example.SpotifyApi.model.Song;
import com.example.SpotifyApi.model.Text;
import com.example.SpotifyApi.repository.SongRepository;
import com.example.SpotifyApi.repository.TextRepository;

@Service
public class TextServiceImpl implements TextService{

	@Autowired
	private TextRepository textRepository;
	
	@Override
	public TextResponse createText(TextEntity text) { 
		
		String uniqueID = UUID.randomUUID().toString();	
		Text labelModel = new Text();
		labelModel.setLyrics(text.getLyrics());
		labelModel.setName(text.getName());
		TextResponse resp = new TextResponse();
		resp.setId(uniqueID);
		resp.setLyrics(text.getLyrics());
		resp.setName(text.getName());
		return resp ;
	}
	
	@Override
	public ArrayList<Text> getAllTexts() {
		return textRepository.getAllTexts();
	}

	@Override
	public Text getText(String id) {
		return textRepository.getText(id);
	}

	@Override
	public void updateText(String id, TextEntity textEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteText(String id) {
		try {
			textRepository.deleteText(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
