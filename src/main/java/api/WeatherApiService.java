package api;

import api.dto.CityWeatherDto;
import api.open_weather.OpenWeatherApiService;
import api.weatherbit.WeatherBitApiService;
import api.weatherstack.WeatherStackApiService;

public class WeatherApiService {
	
	public CityWeatherDto getDataFromOpenWeather(String cityName) {
		return new OpenWeatherApiService().getData(cityName);
	}
	public CityWeatherDto getDataFromWeatherStack(String cityName) {
		return new WeatherStackApiService().getData(cityName);
	}
	public CityWeatherDto getDataFromWeatherBit(String cityName) {
		return new WeatherBitApiService().getData(cityName);
	}
	
}
