package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Label;

@Repository
public interface LabelRepository {
	public Label addLabel(Label label);

	public ArrayList<Label> getAllLabels();

	public Label getLabel(long id);

	public Boolean updateLabel(long id, Label label) throws IOException;

	public Boolean deleteLabel(long id) throws IOException;
}
