package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {
  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  //@GetMapping("/")
  /*public String hello() {
    return "New Music Coming Soon!";
  }*/
  @GetMapping("/WeatherData")
  public String getWeatherData(@RequestParam("zip") String zipcode){
          Sounder  sounder = new Sounder();
	  RestTemplate restTemplate = new RestTemplate();
	  Weather weather;
	  if(zipcode.isEmpty()){
	  weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?zip=48340&APPID=cf32c0bcc723a965df94aeb04388c1ee", Weather.class);}
	  else{
	  weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?zip="+zipcode+"&APPID=cf32c0bcc723a965df94aeb04388c1ee", Weather.class);
	  }
	  double temp = weather.getWeatherList().get(0).getMain().getTemp();
	  double windSpeed = weather.getWeatherList().get(0).getWind().getSpeed();
	  System.out.println(sounder.getMusicLink(sounder.getMusicSettings(weather.getWeatherList().get(0))));
    return sounder.getMusicLink(sounder.getMusicSettings(weather.getWeatherList().get(0)));
  }
  @GetMapping("/WeatherJson")
  public Weather getWeatherInfo(){
	RestTemplate restTemplate = new RestTemplate();
	Weather weather = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?zip=48340&APPID=cf32c0bcc723a965df94aeb04388c1ee", Weather.class);
	return weather;
  }
}
