package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.repository.SongRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;

	private long idCounter = 1L;

	@Override
	public Song createSong(Song song) {
		song.setId(idCounter++);
		songRepository.addSong(song);
		return song;
	}

	@Override
	public ArrayList<Song> getAllSongs() {
		return songRepository.getAllSongs();
	}

	@Override
	public Song getSong(long id) {
		return songRepository.getSong(id);
	}

	@Override
	public Boolean updateSong(long id, Song song) {

		Boolean ifExist = false;

		try {
			ifExist = songRepository.updateSong(id, song);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}

	@Override
	public Boolean deleteSong(long id) {

		Boolean ifExist = false;
		try {
			ifExist = songRepository.deleteSong(id);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ifExist;
	}
}
