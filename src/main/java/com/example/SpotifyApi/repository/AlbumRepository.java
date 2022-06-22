package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Album;

@Repository
public interface AlbumRepository {
	public ArrayList<Album> getAllAlbums();
	public Album getAlbum(String id);
	public void updateAlbum(String id, Album albumEntity) throws IOException;
	public void deleteAlbum(String id) throws IOException;
}
