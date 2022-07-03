package ua.lviv.iot.spotifyapi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Song;
import ua.lviv.iot.spotifyapi.model.Text;

@Service
public interface SongService {
	Song createSong(Song song);

	ArrayList<Song> getAllSongs();

	Song getSong(long id);

	Boolean updateSong(long id, Song song);

	Boolean deleteSong(long id);

	Text getSongText(long id);
}
