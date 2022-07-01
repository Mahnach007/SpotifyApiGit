package com.example.SpotifyApi.servise;

import java.util.ArrayList;


import org.springframework.stereotype.Service;


import com.example.SpotifyApi.model.Label;

@Service
public interface LabelService {

	public Label createLabel(Label label);
	public ArrayList<Label> getAllLabels();
	public Label getLabel(long id);
	public Boolean updateLabel(long id, Label label);
	public Boolean deleteLabel(long id);
}
