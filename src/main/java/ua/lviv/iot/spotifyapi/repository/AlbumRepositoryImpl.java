package ua.lviv.iot.spotifyapi.repository;


import java.io.IOException;


import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Album;


@Repository
public class AlbumRepositoryImpl  extends BaseCSVRepository<Album> implements AlbumRepository {
	
	public AlbumRepositoryImpl() throws IOException {
		super("album",  new String [] {"id", "name", "date"}, Album.class);
	}

	@Override
	public ArrayList<Album> getAllAlbums() {
		recreateDataSourceIfNewDay();
		ArrayList<Album> list = new ArrayList<>(entities.values());
		return list;
	}

	@Override
	public Album getAlbum(long id) {
		recreateDataSourceIfNewDay();
		return entities.get(id);
	}

	@Override
	public Album addAlbum(Album album) {

		recreateDataSourceIfNewDay();

		entities.put(album.getId(), album);
		try {
			saveToCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return album;

	}

	@Override
	public Boolean deleteAlbum(long id) {
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
	public Boolean updateAlbum(long id, Album album) {
		
		recreateDataSourceIfNewDay();

		if (entities.containsKey(id)) {

			entities.put(id, album);
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
