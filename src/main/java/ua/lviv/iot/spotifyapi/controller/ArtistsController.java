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
import ua.lviv.iot.spotifyapi.model.Artist;
import ua.lviv.iot.spotifyapi.servise.ArtistsService;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

	@Autowired
	private ArtistsService artistService;

	@GetMapping
	public ResponseEntity<ArrayList<Artist>> getAllArtists() {
		return new ResponseEntity<>(artistService.getAllArtists(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Artist> getArtist(@PathVariable long id) {
		Artist artist = artistService.getArtist(id);
		return new ResponseEntity<>(artist, artist == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
	}

	@GetMapping("/{id}/albums")
	public ResponseEntity<ArrayList<Album>> getArtistAlbums(@PathVariable long id) {
		ArrayList<Album> albums = artistService.getArtistAlbums(id);
		return new ResponseEntity<>(albums, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Artist> addArtist(@RequestBody Artist artist) {
		return new ResponseEntity<>(artistService.createArtist(artist), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateArtist(@PathVariable long id, @RequestBody Artist artist) {
		Boolean ifExist = artistService.updateArtist(id, artist);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteArtist(@PathVariable long id) {
		Boolean ifExist = artistService.deleteArtist(id);
		return new ResponseEntity<>(ifExist ? HttpStatus.NO_CONTENT : HttpStatus.NOT_FOUND);
	}

}
