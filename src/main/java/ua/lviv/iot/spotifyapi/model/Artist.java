package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist extends BaseModel {

	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "age")
	private int age;
	@CsvBindByName(column = "artistLabel")
	private String artistLabel;

}
