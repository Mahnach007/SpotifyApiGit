package com.example.SpotifyApi.servise;

import java.util.ArrayList;


import org.springframework.stereotype.Service;


import com.example.SpotifyApi.model.Album;


@Service
public interface AlbumService {
	
	public Album createAlbum(Album album);
	public ArrayList<Album> getAllAlbums();
	public Album getAlbum(long id);
	public Boolean updateAlbum(long id, Album albumEntity);
	public Boolean deleteAlbum(long id);
	
	
}