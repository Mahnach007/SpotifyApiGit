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
import ua.lviv.iot.spotifyapi.model.Text;
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
		Song song = songService.getSong(id);
		return new ResponseEntity<>(song, song == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@GetMapping("/{id}/text")
	public ResponseEntity<Text> getSongText(@PathVariable long id) {
		Text text = songService.getSongText(id);
		return new ResponseEntity<>(text, text == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Song> addSong(@RequestBody Song song) {
		return new ResponseEntity<>(songService.createSong(song), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateSong(@PathVariable long id, @RequestBody Song song) {
		Boolean ifExist = songService.updateSong(id, song);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteSong(@PathVariable long id) {
		Boolean ifExist = songService.deleteSong(id);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);

	}
}
