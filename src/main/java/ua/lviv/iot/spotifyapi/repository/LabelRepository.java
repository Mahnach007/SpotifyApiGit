package ua.lviv.iot.spotifyapi.repository;

import java.io.IOException;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import ua.lviv.iot.spotifyapi.model.Label;

@Repository
public interface LabelRepository {
	Label addLabel(Label label);

	ArrayList<Label> getAllLabels();

	Label getLabel(long id);

	Boolean updateLabel(long id, Label label) throws IOException;

	Boolean deleteLabel(long id) throws IOException;

	long getLastEntityId();

}
