package com.example.SpotifyApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpotifyApi.servise.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumCntroller {
	


	
	@GetMapping
	public ResponseEntity<Integer> getAllAlbums() {
		return new ResponseEntity<>(12, HttpStatus.OK);
	}	
	
	@PostMapping
	public ResponseEntity<String> addAlbum(@RequestParam("h") String nameValue){
		return new ResponseEntity<>("Hello" + nameValue, HttpStatus.CREATED);
	}	
	
	@PutMapping
	public ResponseEntity<String> updateAlbum(@RequestParam("h") String nameValue){
		return new ResponseEntity<>("Hello" + nameValue, HttpStatus.OK);
		
	}	
	@DeleteMapping
	public ResponseEntity<String> deleteAlbum(@RequestParam("h") String nameValue){
		return new ResponseEntity<>("Hello" + nameValue, HttpStatus.OK);
		
	}	
}
