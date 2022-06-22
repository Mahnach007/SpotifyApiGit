package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;


import com.example.SpotifyApi.model.Label;

public interface LabelRepository {
	public ArrayList<Label> getAllLabels();
	public Label getLabel(String id);
	public void updateLabel(String id, Label lableEntity) throws IOException;
	public void deleteLabel(String id) throws IOException;
}
