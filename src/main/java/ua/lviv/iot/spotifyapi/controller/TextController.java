package ua.lviv.iot.spotifyapi.controller;

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

import ua.lviv.iot.spotifyapi.model.Text;
import ua.lviv.iot.spotifyapi.servise.TextService;


@RestController
@RequestMapping("/text")
public class TextController {
	
	@Autowired
	private TextService textService;
	
	
	@GetMapping
	public ResponseEntity<ArrayList<Text>> getAllTexts() {
		return new ResponseEntity<>(textService.getAllTexts(), HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Text> getText(@PathVariable long id) {
		return new ResponseEntity<>(textService.getText(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity<Text> addText(@RequestBody Text text){
		return new ResponseEntity<>(textService.createText(text), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateText(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteText(@PathVariable long id){
		textService.deleteText(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
}
