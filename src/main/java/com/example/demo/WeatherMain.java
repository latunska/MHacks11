package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherMain {

	public WeatherMain() {
	}
	private double temp;
	public double getTemp(){
		return temp;
	}
	public void setTemp(double temp){
		this.temp=temp;
	}


}
