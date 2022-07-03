package ua.lviv.iot.spotifyapi.model;

import com.opencsv.bean.CsvBindByName;


import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class Text extends BaseModel{
	

	@CsvBindByName(column = "lyrics")
	private String lyrics;
	@CsvBindByName(column = "songId")
	private int songId;
}
