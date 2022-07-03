package ua.lviv.iot.spotifyapi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Album;
import ua.lviv.iot.spotifyapi.model.Song;


@Service
public interface AlbumService {
	
	 Album createAlbum(Album album);

	 ArrayList<Album> getAllAlbums();

	 Album getAlbum(long id);

	 Boolean updateAlbum(long id, Album albumEntity);

	 Boolean deleteAlbum(long id);

	 ArrayList<Song> getAlbumSongs(long id);
	
	
}