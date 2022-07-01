package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Album;

@Repository
public interface AlbumRepository {
	public ArrayList<Album> getAllAlbums();

	public Album getAlbum(long id);

	public Boolean updateAlbum(long id, Album album) throws IOException;

	public Boolean deleteAlbum(long id) throws IOException;

	public Album addAlbum(Album album);
}
