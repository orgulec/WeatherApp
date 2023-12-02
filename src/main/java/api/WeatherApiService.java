package api;

import api.dto.CityWeatherDto;
import api.open_weather.OpenWeatherApiService;
import api.weatherbit.WeatherBitApiService;
import api.weatherstack.WeatherStackApiService;

import java.util.ArrayList;

public class WeatherApiService {
	
	private CityWeatherDto getDataFromOpenWeather(String cityName) {
		return new OpenWeatherApiService().getData(cityName);
	}
	private CityWeatherDto getDataFromWeatherStack(String cityName) {
		return new WeatherStackApiService().getData(cityName);
	}
	private CityWeatherDto getDataFromWeatherBit(String cityName) {
		return new WeatherBitApiService().getData(cityName);
	}

	public ArrayList<CityWeatherDto> getData(String cityName){
		ArrayList<CityWeatherDto> listOfWeatherDto = new ArrayList<>();
		listOfWeatherDto.add(getDataFromOpenWeather(cityName));
		listOfWeatherDto.add(getDataFromWeatherStack(cityName));
		listOfWeatherDto.add(getDataFromWeatherBit(cityName));
		return listOfWeatherDto;
	}
}
