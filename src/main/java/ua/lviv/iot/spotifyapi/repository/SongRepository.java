package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Song;

@Repository
public interface SongRepository {
	Song addSong(Song song);

	ArrayList<Song> getAllSongs();

	Song getSong(long id);

	Boolean updateSong(long id, Song song) throws IOException;

	Boolean deleteSong(long id) throws IOException;

	long getLastEntityId();

	ArrayList<Song> getSongsByAlbum(long id);
}
