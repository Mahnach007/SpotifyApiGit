package com.example.SpotifyApi.servise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.LabelResponse;
import com.example.SpotifyApi.entities.LabelEntity;

import com.example.SpotifyApi.model.Label;

import com.example.SpotifyApi.repository.LabelRepository;

@Service
public class LabelServiceImpl implements LabelService{

	
	@Autowired
	private LabelRepository labelRepository;
	
	@Override
	public LabelResponse createLabel(LabelEntity label) { 
		
		String uniqueID = UUID.randomUUID().toString();	
		Label labelModel = new Label();
		labelModel.setDate(label.getDate());
		labelModel.setLabelCreator(label.getLabelCreator());
		labelModel.setName(label.getName());
		LabelResponse resp = new LabelResponse();
		resp.setId(uniqueID);
		resp.setDate(label.getDate());
		resp.setName(label.getName());
		resp.setLabelCreator(label.getLabelCreator());
		return resp ;
	}
	

	@Override
	public ArrayList<Label> getAllLabels() {
		return labelRepository.getAllLabels();
	}

	@Override
	public Label getLabel(String id) {
		return labelRepository.getLabel(id);
	}

	@Override
	public void updateLabel(String id, LabelEntity labelEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteLabel(String id) {
		try {
			labelRepository.deleteLabel(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
