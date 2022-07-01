package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Artist;

@Repository
public class ArtistRepositoryImpl extends BaseCSVRepository<Artist> implements ArtistRepository {

	public ArtistRepositoryImpl() throws IOException {
		super("artist",  new String[] { "id", "age", "name", "artistLabel" }, Artist.class);
		
	}

	public ArrayList<Artist> getAllArtists() {
		recreateDataSourceIfNewDay();
		ArrayList<Artist> list = new ArrayList<>(entities.values());
		return list;
	}

	public Artist getArtist(long id) {
		recreateDataSourceIfNewDay();
		return entities.get(id);
	}

	public Artist addArtist(Artist artist) {

		recreateDataSourceIfNewDay();
		entities.put(artist.getId(), artist);
		try {
			saveToCSV();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return artist;

	}

	public Boolean deleteArtist(long id) {
		recreateDataSourceIfNewDay();

		if (entities.remove(id) == null) {
			return false;
		}
		if (!entities.isEmpty()) {
			try {
				saveToCSV();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			writeCSVHeadersToFile(filePath);
		}
		return true;
	}

	public Boolean updateArtist(long id, Artist artist) {
		recreateDataSourceIfNewDay();

		if (entities.containsKey(id)) {

			entities.put(id, artist);
			try {
				saveToCSV();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return true;
		}

		return false;
	}

}
