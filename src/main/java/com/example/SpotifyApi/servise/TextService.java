package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.TextResponse;
import com.example.SpotifyApi.entities.TextEntity;
import com.example.SpotifyApi.model.Text;

@Service
public interface TextService {
	public TextResponse createText(TextEntity text);
	public ArrayList<Text> getAllTexts();
	public Text getText(String id);
	public void updateText(String id,TextEntity textEntity);
	public void deleteText(String id);
}
