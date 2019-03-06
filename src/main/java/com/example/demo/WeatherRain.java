package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherRain {

	public WeatherRain() {
	}
	@JsonProperty("3h")
	private double threeHours;
	public double getThreeHours(){
		return threeHours;
	}
	public void setThreeHours(double threeHours){
		this.threeHours=threeHours;
	}


}
