package com.example.SpotifyApi.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpotifyApi.Payload.ArtistResponse;
import com.example.SpotifyApi.Payload.LabelResponse;
import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.entities.LabelEntity;
import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.model.Label;
import com.example.SpotifyApi.servise.ArtistsService;
import com.example.SpotifyApi.servise.LabelService;

@RestController
@RequestMapping("/Label")
public class LabelController {
	
	@Autowired
	private LabelService labelService;
	
	
	@GetMapping
	public ResponseEntity<ArrayList<Label>> getAllLabels() {
		return new ResponseEntity<>(labelService.getAllLabels(), HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Label> getLabel(@PathVariable String id) {
		return new ResponseEntity<>(labelService.getLabel(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity <LabelResponse> addLabel(@RequestBody LabelEntity Label){
	
	
		return new ResponseEntity<>(labelService.createLabel(Label), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateLabel(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLabel(@PathVariable String id){
		labelService.deleteLabel(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
}
