package com.example.SpotifyApi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class Text {
	
	@CsvBindByName(column = "id")
	private String id;
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "lyrics")
	private String lyrics;
}
