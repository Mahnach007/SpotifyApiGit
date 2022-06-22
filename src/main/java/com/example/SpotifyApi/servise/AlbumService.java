package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.AlbumResponse;
import com.example.SpotifyApi.entities.AlbumEntity;
import com.example.SpotifyApi.model.Album;


@Service
public interface AlbumService {
	
	public AlbumResponse createAlbum(AlbumEntity album);
	public ArrayList<Album> getAllAlbums();
	public Album getAlbum(String id);
	public void updateAlbum(String id, AlbumEntity albumEntity);
	public void deleteAlbum(String id);
	
	
}