package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherWind {

	public WeatherWind() {
	}
	private double speed;
	public double getSpeed(){
		return speed;
	}
	public void setSpeed(double speed){
		this.speed=speed;
	}


}
