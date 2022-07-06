package ua.lviv.iot.spotifyapi.servise;

import java.io.IOException;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.model.Text;
import ua.lviv.iot.spotifyapi.repository.SongRepository;
import ua.lviv.iot.spotifyapi.repository.TextRepository;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	private SongRepository songRepository;

	@Autowired
	private TextRepository textRepository;

	private long idCounter = 1L;

	@PostConstruct
	public void init() {
		idCounter = songRepository.getLastEntityId();
	}

	@Override
	public Song createSong(Song song) {
		song.setId(++idCounter);
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
	public Text getSongText(long id) {
		return textRepository.getTextBySong(id);
	}

	@Override
	public Boolean updateSong(long id, Song song) {
		song.setId(id);
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
