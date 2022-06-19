package com.example.SpotifyApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpotifyApi.entities.SongEntity;
import com.example.SpotifyApi.servise.SongService;


@RestController
@RequestMapping("/song")
public class SongController {
	
	
	@GetMapping
	public ResponseEntity<Integer> getAllSongs() {
		return new ResponseEntity<>(12, HttpStatus.OK);
	}	
	
	@PostMapping
	public ResponseEntity <SongEntity> addSong(@RequestBody SongEntity song){
		
		//int id = songService.createArtist(artist);
		return new ResponseEntity<>( song, HttpStatus.CREATED);
	}	
	@PutMapping
	public ResponseEntity<String> updateArtist(@RequestParam("h") String nameValue){
		return new ResponseEntity<>("Hello" + nameValue, HttpStatus.OK);
		
	}	
	@DeleteMapping
	public ResponseEntity<String> deleteArtist(@RequestParam("h") String nameValue){
		return new ResponseEntity<>("Hello" + nameValue, HttpStatus.OK);
		
	}	
}
