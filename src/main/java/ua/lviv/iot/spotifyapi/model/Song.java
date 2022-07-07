package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song extends BaseModel {

	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "date")
	private String date;
	@CsvBindByName(column = "albumId")
	private int albumId;

}
