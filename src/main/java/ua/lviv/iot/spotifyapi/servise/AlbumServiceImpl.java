package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Album;
import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.repository.AlbumRepository;
import ua.lviv.iot.spotifyapi.repository.SongRepository;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	private AlbumRepository albumRepository;
	@Autowired
	private SongRepository songRepository;

	private long idCounter = 1L;

	@PostConstruct
	public void init() {
		idCounter = albumRepository.getLastEntityId();
	}

	@Override
	public Album createAlbum(Album album) {
		album.setId(++idCounter);
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
	public ArrayList<Song> getAlbumSongs(long id) {
		return songRepository.getSongsByAlbum(id);
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
