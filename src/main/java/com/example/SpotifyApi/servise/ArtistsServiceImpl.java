package com.example.SpotifyApi.servise;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.repository.ArtistRepository;

@Service
public class ArtistsServiceImpl implements ArtistsService {

	@Autowired
	private ArtistRepository artistRepository;

	private long idCounter = 1L;

	@Override
	public Artist createArtist(Artist artist) {
		artist.setId(idCounter++);
		artistRepository.addArtist(artist);
		return artist;
	}

	@Override
	public ArrayList<Artist> getAllArtists() {
		return artistRepository.getAllArtists();
	}

	@Override
	public Artist getArtist(long id) {
		return artistRepository.getArtist(id);
	}

	@Override
	public Boolean updateArtist(long id, Artist artist) {

		Boolean ifExist = false;
		try {
			ifExist = artistRepository.updateArtist(id, artist);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

	@Override
	public Boolean deleteArtist(long id) {

		Boolean ifExist = false;
		try {
			ifExist = artistRepository.deleteArtist(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}
}
