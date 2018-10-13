package com.example.demo;

import com.fasterxml.jackson.annotation.*;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherCloud {

	public WeatherCloud() {
	}
	private int all;
	public int getAll(){
		return all;
	}
	public void setAll(int all){
		this.all=all;
	}


}
