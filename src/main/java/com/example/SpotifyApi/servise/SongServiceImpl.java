package com.example.SpotifyApi.servise;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpotifyApi.Payload.SongResponse;
import com.example.SpotifyApi.entities.SongEntity;
import com.example.SpotifyApi.model.Song;
import com.example.SpotifyApi.repository.SongRepository;


@Service
public class SongServiceImpl implements SongService {

	
	@Autowired
	private SongRepository songRepository;
	
	@Override
	public SongResponse createSong(SongEntity song) { 
		
		String uniqueID = UUID.randomUUID().toString();	
		Song labelModel = new Song();
		labelModel.setDate(song.getDate());
		labelModel.setArtist(song.getArtist());
		labelModel.setName(song.getName());
		SongResponse resp = new SongResponse();
		resp.setId(uniqueID);
		resp.setDate(song.getDate());
		resp.setName(song.getName());
		resp.setArtist(song.getArtist());
		return resp ;
	}
	

	@Override
	public ArrayList<Song> getAllSongs() {
		return songRepository.getAllSongs();
	}

	@Override
	public Song getSong(String id) {
		return songRepository.getSong(id);
	}

	@Override
	public void updateSong(String id, SongEntity songEntity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSong(String id) {
		try {
			songRepository.deleteSong(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
