package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label extends BaseModel{
	
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "date")
	private String date;
	@CsvBindByName(column = "labelCreator")
	private String labelCreator;
	
}
