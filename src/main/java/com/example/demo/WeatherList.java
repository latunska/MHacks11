package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherList {

	public WeatherList() {
	}
	private int dt;
	private WeatherMain main;
	private WeatherRain rain;
	private WeatherRain snow;
	private WeatherCloud clouds;
	private WeatherWind wind;
	public WeatherMain getMain(){
		return main;
	}
	public void setMain(WeatherMain main){
		this.main=main;
	}
	public WeatherRain getRain(){
		return rain;
	}
	public void setRain(WeatherRain rain){
		this.rain=rain;
	}
	public WeatherRain getSnow(){
		return snow;
	}
	public void setSnow(WeatherRain snow){
		this.snow=snow;
	}
	public WeatherCloud getClouds(){
		return clouds;
	}
	public void setClouds(WeatherCloud clouds){
		this.clouds=clouds;
	}
	public WeatherWind getWind(){
		return wind;
	}
	public void setWind(WeatherWind wind){
		this.wind=wind;
	}
	public int getDt(){
		return dt;
	}
	public void setDt(int dt){
		this.dt=dt;
	}
}
