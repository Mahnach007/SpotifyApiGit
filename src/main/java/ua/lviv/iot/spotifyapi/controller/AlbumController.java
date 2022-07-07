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
import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.servise.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	@GetMapping
	public ResponseEntity<ArrayList<Album>> getAllAlbums() {
		return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Album> getAlbum(@PathVariable long id) {
		Album album = albumService.getAlbum(id);
		return new ResponseEntity<>(album, album == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@GetMapping("/{id}/songs")
	public ResponseEntity<ArrayList<Song>> getAlbumSongs(@PathVariable long id) {
		ArrayList<Song> songs = albumService.getAlbumSongs(id);
		return new ResponseEntity<>(songs, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Album> addAlbum(@RequestBody Album album) {

		return new ResponseEntity<>(albumService.createAlbum(album), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateAlbum(@PathVariable long id, @RequestBody Album album) {
		Boolean ifExist = albumService.updateAlbum(id, album);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteAlbum(@PathVariable long id) {
		Boolean ifExist = albumService.deleteAlbum(id);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);

	}
}
