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

	/*public List<Weather> getWeatherDatas(String json) {
		ObjectMapper mapper = new ObjectMapper();
		List<Weather> weathers = new ArrayList<Weather>();
		try {
			JsonNode nodes = mapper.readTree(json);
			int i = 0;
			while(nodes.path("list").has(i)) {
				Weather weather = new Weather();
				weather.clouds = nodes.path("list").path(i).path("clouds").path("all").intValue();
				weather.temp = nodes.path("list").path(i).path("main").path("temp").doubleValue();
				weather.wind = nodes.path("list").path(i).path("wind").path("speed").doubleValue();
				weather.precipitation = nodes.path("list").path(i).path("rain").path("3h").doubleValue() +
						nodes.path("list").path(i).path("snow").path("3h").doubleValue();
				weather.weather = nodes.path("list").path(i).path("weather").path(0).path("description").textValue();
				weathers.add(weather);
				i++;
			}
		}catch (JsonParseException e){
			System.out.print(("see"));
		}catch (JsonMappingException e){
			System.out.print("broke");
		}catch (IOException e){
			System.out.print("nothin");
		}
		return weathers;
	}

	public Weather getWeatherData(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Weather weather = new Weather();
		try {
			JsonNode nodes = mapper.readTree(json);
			weather.clouds = nodes.path("list").path(0).path("clouds").path("all").intValue();
			weather.temp = nodes.path("list").path(0).path("main").path("temp").doubleValue();
			weather.wind = nodes.path("list").path(0).path("wind").path("speed").doubleValue();
			weather.precipitation = nodes.path("list").path(0).path("rain").path("3h").doubleValue()+
					nodes.path("list").path(0).path("snow").path("3h").doubleValue();
			weather.weather = nodes.path("list").path(0).path("weather").path(0).path("description").textValue();
		}catch (JsonParseException e){
			System.out.print(("see"));
		}catch (JsonMappingException e){
			System.out.print("broke");
		}catch (IOException e){
			System.out.print("nothin");
		}
		return weather;
	}*/

	public MusicSettings getMusicSettings(WeatherList weather) {
		MusicSettings settings = new MusicSettings();

		// temperature -> tempo
		settings.tempo = (int)((weather.getMain().getTemp() -244)/(333-244)*130+50);
		//
		settings.pitch = (int)((1 - (weather.getRain().getThreeHours() - 0) / 1)*48+24);
		settings.duration = (int)(settings.tempo*2.5);

		settings.instruments[0]=1;
		settings.instruments[1]=1;

		/*if(weather.weather.contains("rain"))
			settings.tones = 2903;
*/
		if(weather.getWind().getSpeed() > 15)
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
