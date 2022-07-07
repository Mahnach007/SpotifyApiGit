package ua.lviv.iot.spotifyapi.servise;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ua.lviv.iot.spotifyapi.model.Artist;
import ua.lviv.iot.spotifyapi.model.Label;

@Service
public interface LabelService {

	Label createLabel(Label label);

	ArrayList<Label> getAllLabels();

	Label getLabel(long id);

	Boolean updateLabel(long id, Label label);

	Boolean deleteLabel(long id);

	ArrayList<Artist> getLabelArtists(long id);
}
