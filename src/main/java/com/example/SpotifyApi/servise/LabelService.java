package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.LabelResponse;
import com.example.SpotifyApi.entities.LabelEntity;
import com.example.SpotifyApi.model.Label;

@Service
public interface LabelService {

	public LabelResponse createLabel(LabelEntity label);
	public ArrayList<Label> getAllLabels();
	public Label getLabel(String id);
	public void updateLabel(String id,LabelEntity labelEntity);
	public void deleteLabel(String id);
}
