package com.example.SpotifyApi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class Text extends BaseModel{
	
	@CsvBindByName
	private String name;
	@CsvBindByName
	private String lyrics;
}
