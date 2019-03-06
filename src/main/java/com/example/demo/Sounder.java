package com.example.demo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sounder {
	public Sounder(){

	}

	public int getWeather(Weather weather){
		return weather.getWeatherList().get(0).getWeather().get(0).getId();
	}

	public MusicSettings getMusicSettings(WeatherList weather) {
		MusicSettings settings = new MusicSettings();

		// temperature -> tempo
		settings.tempo = (int)((weather.getMain().getTemp() -250)/(350-250)*130+50);
		double precip=0;
		if(weather.getSnow()!=null) {
			precip = weather.getSnow().getThreeHours();
		}
		if(weather.getRain()!=null) {
			precip += weather.getRain().getThreeHours();
		}

		settings.pitch = (int) ((0.2 - precip) / 0.2 * 24.0 + 12.0) < 12 ? 12 : (int) ((0.2 - precip) / 0.2 * 24.0 + 12.0);
		settings.pitch += (int) ((100 - weather.getClouds().getAll()) / 100 * 24.0 + 12.0) < 12 ? 12 : (int) ((100 - weather.getClouds().getAll()) / 100 * 24.0 + 12.0);

		settings.duration = (int)(settings.tempo*2.5);

		settings.instruments[0] = 1;
		settings.instruments[1] = 1;

		if(weather.getClouds().getAll() > 50) {
			settings.instruments[0]=20;
			settings.instruments[1]=570;
			settings.tones = 2911;
		}

		/*if(weather.weather.contains("rain"))
			settings.tones = 2903;
*/
		if(weather.getWind().getSpeed() > 5)
			settings.percussion = 333;

		//System.out.println(weather.weather);

		//random seed
		settings.seed = (int)((Math.random() * ((16383 - 8193) + 1)) + 8193);
		return settings;
	}

	public String getMusicLink(MusicSettings settings){
		String output =  "https://www.wolframcloud.com/objects/user-a13d29f3-43bf-4b00-8e9b-e55639ecde19/NKMMusic?id=NKM-G-13-"+settings.ruletype+"-"+settings.rule+"-0-"+settings.seed+"-"+settings.duration+"-"+settings.tempo+"-"+settings.notesPerBeat+"-"+settings.tones+"-"+settings.pitch+"-0-27-169";
		for(int i : settings.instruments)
			output+="-"+i;

		output+="-"+settings.percussion;
		return output;
	}
}
