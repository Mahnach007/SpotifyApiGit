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


import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.servise.SongService;


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
	public ResponseEntity<Song> getSong(@PathVariable long id) {
		return new ResponseEntity<>(songService.getSong(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity<Song> addSong(@RequestBody Song song){
		return new ResponseEntity<>(songService.createSong(song), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateSong(@PathVariable String id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSong(@PathVariable long id){
		songService.deleteSong(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
}
