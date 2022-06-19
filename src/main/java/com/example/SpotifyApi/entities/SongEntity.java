package com.example.SpotifyApi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SongEntity {
	
	private String name;
	private String artist;
	private String date;
}
