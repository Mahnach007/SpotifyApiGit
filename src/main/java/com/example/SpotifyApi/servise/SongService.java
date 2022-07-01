package com.example.SpotifyApi.servise;

import java.util.ArrayList;


import org.springframework.stereotype.Service;


import com.example.SpotifyApi.model.Song;

@Service
public interface SongService {
	public Song createSong(Song song);
	public ArrayList<Song> getAllSongs();
	public Song getSong(long id);
	public Boolean updateSong(long id, Song song);
	public Boolean deleteSong(long id);
}

