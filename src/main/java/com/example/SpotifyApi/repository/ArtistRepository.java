package com.example.SpotifyApi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Artist;

@Repository
public interface ArtistRepository {

	public Artist addArtist(Artist artist);

	public ArrayList<Artist> getAllArtists();

	public Artist getArtist(long id);

	public Boolean updateArtist(long id, Artist artist) throws IOException;

	public Boolean deleteArtist(long id) throws IOException;

}
