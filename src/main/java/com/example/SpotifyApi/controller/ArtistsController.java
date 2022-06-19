package com.example.SpotifyApi.controller;

import java.util.ArrayList;
import java.util.UUID;

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

import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.Payload.ArtistResponse;
import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.servise.ArtistsService;



@RestController
@RequestMapping("/artists")
public class ArtistsController  {
	
	@Autowired
	private ArtistsService artistService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Artist>> getAllArtists() {
		return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Artist> getArtist(@PathVariable String id) {
		return new ResponseEntity<>(artistService.getArtist(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity <ArtistResponse> addArtist(@RequestBody ArtistEntity artist){
		ArtistResponse resp = artistService.createArtist(artist);
	
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateArtist(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArtist(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	

}
