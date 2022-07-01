package com.example.SpotifyApi.servise;

import java.io.IOException;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.model.Album;
import com.example.SpotifyApi.model.Artist;
import com.example.SpotifyApi.repository.AlbumRepository;
import com.example.SpotifyApi.repository.ArtistRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;

	private long idCounter = 1L;

	@Override
	public Album createAlbum(Album album) {
		album.setId(idCounter++);
		albumRepository.addAlbum(album);
		return album;
	}

	@Override
	public ArrayList<Album> getAllAlbums() {
		return albumRepository.getAllAlbums();
	}

	@Override
	public Album getAlbum(long id) {
		return albumRepository.getAlbum(id);
	}

	@Override
	public Boolean updateAlbum(long id, Album album) {

		Boolean ifExist = false;

		try {
			ifExist = albumRepository.updateAlbum(id, album);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

	@Override
	public Boolean deleteAlbum(long id) {

		Boolean ifExist = false;
		try {
			ifExist = albumRepository.deleteAlbum(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}
}
