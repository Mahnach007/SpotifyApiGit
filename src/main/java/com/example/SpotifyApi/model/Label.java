package com.example.SpotifyApi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Label {
	
	@CsvBindByName(column = "id")
	private String id;
	@CsvBindByName(column = "name")
	private String name;
	@CsvBindByName(column = "date")
	private String date;
	@CsvBindByName(column = "labelCreator")
	private String labelCreator;
	
}
