package com.example.SpotifyApi.Payload;



import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SongResponse {
	
	private String id;
	private String name;
	private String artist;
	private String date;
}
