package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Album;
import ua.lviv.iot.spotifyapi.model.Artist;
import ua.lviv.iot.spotifyapi.repository.AlbumRepository;
import ua.lviv.iot.spotifyapi.repository.ArtistRepository;

@Service
public class ArtistsServiceImpl implements ArtistsService {

	@Autowired
	private ArtistRepository artistRepository;

	@Autowired
	private AlbumRepository albumRepository;

	private long idCounter = 1L;

	@PostConstruct
	public void init() {
		idCounter = artistRepository.getLastEntityId();
	}

	@Override
	public Artist createArtist(Artist artist) {
		artist.setId(++idCounter);
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
	public ArrayList<Album> getArtistAlbums(long id) {
		return albumRepository.getAlbumsByArtist(id);
	}

	@Override
	public Boolean updateArtist(long id, Artist artist) {
		artist.setId(id);
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
