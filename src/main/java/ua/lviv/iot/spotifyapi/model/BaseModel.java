package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseModel {

	@CsvBindByName(column = "id")
	private long id;
}
