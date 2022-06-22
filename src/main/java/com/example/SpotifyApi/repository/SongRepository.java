package com.example.SpotifyApi.repository;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Song;

@Repository	
public interface SongRepository {
	
	public ArrayList<Song> getAllSongs();
	public Song getSong(String id);
	public void updateSong(String id, Song lableEntity) throws IOException;
	public void deleteSong(String id) throws IOException;
}
