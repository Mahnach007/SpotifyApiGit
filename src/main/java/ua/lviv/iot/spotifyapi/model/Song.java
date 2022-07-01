package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Song extends BaseModel{
	
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "artist")
	private String artist;
	@CsvBindByName(column = "date")
	private String date;
}
