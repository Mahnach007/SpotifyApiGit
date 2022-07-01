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

import ua.lviv.iot.spotifyapi.model.Album;
import ua.lviv.iot.spotifyapi.servise.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {
	
	@Autowired
	AlbumService albumService;
	
	@GetMapping
	public ResponseEntity<ArrayList<Album>> getAllAlbums() {
		return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable long id) {
		return new ResponseEntity<>(albumService.getAlbum(id), HttpStatus.OK );
	}	
	
	@PostMapping
	public ResponseEntity <Album> addAlbum(@RequestBody Album album){
			
		return new ResponseEntity<>(albumService.createAlbum(album), HttpStatus.CREATED);
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateAlbum(@PathVariable long id){
		return new ResponseEntity<>( HttpStatus.NO_CONTENT);
		
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAlbum(@PathVariable long id){
		albumService.deleteAlbum(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}	
}
