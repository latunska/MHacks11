package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

	public Weather() {
	}
	private int cod;
	@JsonProperty("list")
	private List<WeatherList> weatherList;
	public List<WeatherList> getWeatherList(){
		return weatherList;
	}
	public void setWeaterList(List<WeatherList> weatherList){
		this.weatherList = weatherList;
	}

	public int getCod(){
		return cod;
	}
	public void setCod(int cod){
		this.cod=cod;
	}
}
