package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWeather {

	public WeatherWeather() {
	}
	private int id;
	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
}
