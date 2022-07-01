package com.example.SpotifyApi.servise;


import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.example.SpotifyApi.model.Artist;

@Service
public interface ArtistsService {
	
	public Artist createArtist(Artist artist);
	public ArrayList<Artist> getAllArtists();
	public Artist getArtist(long id);
	public Boolean updateArtist(long id, Artist artistEntity);
	public Boolean deleteArtist(long id);
	
	
}
