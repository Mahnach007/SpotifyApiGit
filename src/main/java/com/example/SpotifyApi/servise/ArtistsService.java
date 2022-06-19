package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.Payload.ArtistResponse;
import com.example.SpotifyApi.model.Artist;

public interface ArtistsService {
	
	public ArtistResponse createArtist(ArtistEntity artist);
	public ArrayList<Artist> getAllArtists();
	public Artist getArtist(String id);
	public void updateArtist(String id, ArtistEntity artistEntity);
	public void deleteArtist(String id);
	
	
}
