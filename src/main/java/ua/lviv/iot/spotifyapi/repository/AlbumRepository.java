package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Album;

@Repository
public interface AlbumRepository {
	 ArrayList<Album> getAllAlbums();

	 Album getAlbum(long id);

	 Boolean updateAlbum(long id, Album album) throws IOException;

	 Boolean deleteAlbum(long id) throws IOException;

	 Album addAlbum(Album album);
}
