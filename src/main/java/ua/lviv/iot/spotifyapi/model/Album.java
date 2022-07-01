package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Album extends BaseModel{
	
	@CsvBindByName
	private String name;
	@CsvBindByName
	private String date;
}
