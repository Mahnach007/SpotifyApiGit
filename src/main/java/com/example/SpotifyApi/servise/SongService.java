package com.example.SpotifyApi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.SongResponse;
import com.example.SpotifyApi.entities.SongEntity;
import com.example.SpotifyApi.model.Song;

@Service
public interface SongService {
	public SongResponse createSong(SongEntity song);
	public ArrayList<Song> getAllSongs();
	public Song getSong(String id);
	public void updateSong(String id,SongEntity songEntity);
	public void deleteSong(String id);
}

