package com.example.SpotifyApi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.SpotifyApi.model.Song;

@Repository
public interface SongRepository {
	public Song addSong(Song song);

	public ArrayList<Song> getAllSongs();

	public Song getSong(long id);

	public Boolean updateSong(long id, Song song) throws IOException;

	public Boolean deleteSong(long id) throws IOException;
}
