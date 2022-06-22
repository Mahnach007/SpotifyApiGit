package com.example.SpotifyApi.servise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.AlbumResponse;
import com.example.SpotifyApi.entities.AlbumEntity;
import com.example.SpotifyApi.model.Album;
import com.example.SpotifyApi.repository.AlbumRepository;


@Service
public class AlbumServiceImpl implements AlbumService{

	@Autowired
	private AlbumRepository albumRepository;



	@Override
	public AlbumResponse createAlbum(AlbumEntity album) {
		String uniqueID = UUID.randomUUID().toString();	
		Album artistModel = new Album();
		artistModel.setDate(album.getDate());
		artistModel.setName(album.getName());
		AlbumResponse resp = new AlbumResponse();
		resp.setId(uniqueID);
		resp.setDate(album.getDate());
		resp.setName(album.getName());
		return resp ;
	}

	@Override
	public ArrayList<Album> getAllAlbums() {
		return albumRepository.getAllAlbums();
		
	}

	@Override
	public Album getAlbum(String id) {
		return albumRepository.getAlbum(id);
	}
	
	@Override
	public void updateAlbum(String id, AlbumEntity albumEntity) {
		
		// artistRepository.updateArtist(id, artistEntity);
	}

	@Override
	public void deleteAlbum(String id) {
		try {
			albumRepository.deleteAlbum(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	}

	