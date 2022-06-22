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
import com.example.SpotifyApi.Payload.SongResponse;
import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.entities.LabelEntity;
import com.example.SpotifyApi.entities.SongEntity;
import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.model.Label;
import com.example.SpotifyApi.model.Song;
import com.example.SpotifyApi.servise.ArtistsService;
import com.example.SpotifyApi.servise.LabelService;
import com.example.SpotifyApi.servise.SongService;


@RestController
@RequestMapping("/song")
public class SongController {
	
	@Autowired
	private SongService songService;
	
	
	@GetMapping
	public ResponseEntity<ArrayList<Song>> getAllSongs() {
		return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Song> getSong(@PathVariable String id) {
		return new ResponseEntity<>(songService.getSong(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity<SongResponse> addSong(@RequestBody SongEntity Song){
		return new ResponseEntity<>(songService.createSong(Song), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateSong(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSong(@PathVariable String id){
		songService.deleteSong(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
}
