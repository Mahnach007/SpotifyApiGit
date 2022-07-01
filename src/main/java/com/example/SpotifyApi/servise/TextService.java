package com.example.SpotifyApi.servise;

import java.util.ArrayList;


import org.springframework.stereotype.Service;


import com.example.SpotifyApi.model.Text;

@Service
public interface TextService {
	public Text createText(Text text);
	public ArrayList<Text> getAllTexts();
	public Text getText(long id);
	public Boolean updateText(long id, Text text);
	public Boolean deleteText(long id);
}
