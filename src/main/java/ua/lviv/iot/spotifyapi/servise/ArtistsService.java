package ua.lviv.iot.spotifyapi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Album;
import ua.lviv.iot.spotifyapi.model.Artist;

@Service
public interface ArtistsService {

	Artist createArtist(Artist artist);

	ArrayList<Artist> getAllArtists();

	Artist getArtist(long id);

	Boolean updateArtist(long id, Artist artistEntity);

	Boolean deleteArtist(long id);

	ArrayList<Album> getArtistAlbums(long id);

}
