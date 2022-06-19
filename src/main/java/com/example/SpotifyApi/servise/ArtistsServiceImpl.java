package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.entities.ArtistEntity;
import com.example.SpotifyApi.Payload.ArtistResponse;
import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.repository.ArtistRepository;


@Service
public class ArtistsServiceImpl implements ArtistsService{
	
	@Autowired
	private ArtistRepository artistRepository;
	
	@Override
	public ArtistResponse createArtist(ArtistEntity artist) {
		String uniqueID = UUID.randomUUID().toString();	
		Artist artistModel = new Artist();
		artistModel.setAge(artist.getAge());
		artistModel.setArtistLabel(artist.getArtistLabel());
		artistModel.setName(artist.getName());
		ArtistResponse resp = new ArtistResponse();
		resp.setId(uniqueID);
		resp.setAge(artist.getAge());
		resp.setName(artist.getName());
		resp.setArtistLabel(artist.getArtistLabel());
		return resp ;
	}
	
	@Override
	public ArrayList<Artist> getAllArtists(){
		return artistRepository.getAllArtists();
	}

	@Override
	public Artist getArtist(String id) {
		// TODO Auto-generated method stub
		return artistRepository.getArtist(id);
	}

	@Override
	public void updateArtist(String id, ArtistEntity artistEntity) {
		// TODO Auto-generated method stub
		// artistRepository.updateArtist(id, artistEntity);
	}

	@Override
	public void deleteArtist(String id) {
		// TODO Auto-generated method stub
		artistRepository.deleteArtist(id);
	}
}
