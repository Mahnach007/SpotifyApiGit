package com.example.SpotifyApi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Text;

@Repository
public interface TextRepository {
	public Text addText(Text text);

	public ArrayList<Text> getAllTexts();

	public Text getText(long id);

	public Boolean updateText(long id, Text text) throws IOException;

	public Boolean deleteText(long id) throws IOException;
}
