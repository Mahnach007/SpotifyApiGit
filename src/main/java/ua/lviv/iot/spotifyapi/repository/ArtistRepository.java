package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Artist;

@Repository
public interface ArtistRepository {

	 Artist addArtist(Artist artist);

	 ArrayList<Artist> getAllArtists();

	 Artist getArtist(long id);

	 Boolean updateArtist(long id, Artist artist) throws IOException;

	 Boolean deleteArtist(long id) throws IOException;

}
