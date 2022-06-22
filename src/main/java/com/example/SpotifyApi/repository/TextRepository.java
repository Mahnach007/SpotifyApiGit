package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Text;

@Repository	
public interface TextRepository {
	public ArrayList<Text> getAllTexts();
	public Text getText(String id);
	public void updateText(String id, Text textEntity) throws IOException;
	public void deleteText(String id) throws IOException;
}
