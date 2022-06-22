package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.model.Artist;

@Repository
public interface ArtistRepository {
	
	public ArrayList<Artist> getAllArtists();
	public Artist getArtist(String id);
	public void updateArtist(String id, Artist artistEntity) throws IOException;
	public void deleteArtist(String id) throws IOException;
	
}
