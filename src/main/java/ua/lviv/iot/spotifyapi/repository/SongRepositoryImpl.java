package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Song;

@Repository
public class SongRepositoryImpl extends BaseCSVRepository<Song> implements SongRepository {

	public SongRepositoryImpl() throws IOException {
		super("song", new String[] { "id", "name", "artist", "date" });
	
	}

	@Override
	public ArrayList<Song> getAllSongs() {
		recreateDataSourceIfNewDay();
		ArrayList<Song> list = new ArrayList<>(entities.values());
		return list;
	}

	@Override
	public Song getSong(long id) {
		recreateDataSourceIfNewDay();
		return entities.get(id);
	}

	@Override
	public Song addSong(Song song) {

		recreateDataSourceIfNewDay();
		entities.put(song.getId(), song);
		try {
			saveToCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return song;

	}

	@Override
	public Boolean deleteSong(long id) {
		recreateDataSourceIfNewDay();

		if (!entities.containsKey(id)) {
			return false;

		}

		entities.remove(id);
		if (!entities.isEmpty()) {

			try {
				saveToCSV();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {

			writeCSVHeadersToFile(filePath);

		}
		return true;
	}

	@Override
	public Boolean updateSong(long id, Song song) {
		recreateDataSourceIfNewDay();

		if (entities.containsKey(id)) {

			entities.put(id, song);
			try {
				saveToCSV();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}

}
