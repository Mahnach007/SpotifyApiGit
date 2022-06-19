package com.example.SpotifyApi.model;

import com.opencsv.bean.CsvBindByName;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Artist {
	
	@CsvBindByName(column = "id")
	private String id;
	@CsvBindByName(column = "name") //
	private String name;
	@CsvBindByName(column = "age")
	private int age;
	@CsvBindByName(column = "artistLabel")
	private String artistLabel;
}
