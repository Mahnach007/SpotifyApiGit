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
import org.springframework.web.bind.annotation.RestController;

import com.example.SpotifyApi.model.Label;
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
	public ResponseEntity<Label> getLabel(@PathVariable long id) {
		return new ResponseEntity<>(labelService.getLabel(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity <Label> addLabel(@RequestBody Label Label){
	
	
		return new ResponseEntity<>(labelService.createLabel(Label), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateLabel(@PathVariable long id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteLabel(@PathVariable long id){
		labelService.deleteLabel(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
}
