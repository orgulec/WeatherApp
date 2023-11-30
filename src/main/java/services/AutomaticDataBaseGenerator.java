package services;

import api.WeatherApiService;
import api.dto.CityWeatherDto;
import database.CityDataEntity;
import database.CityWeatherDb;
import database.WeatherDataEntityMapper;

import java.util.List;

public class AutomaticDataBaseGenerator {
    public static CityWeatherDb DATA_BASE = new CityWeatherDb();
    public static void generateBasicDataBaseAtStart() {
        System.out.println("\nInitalising Application DB...!");

        final List<String> popularCities = List.of("Warsaw", "Cracow", "Szczecin", "Katowice");//, "Gdansk", "Poznan","Wroclaw","Gdynia");
        popularCities
                .forEach(cityName -> {
                    try {
                        WeatherApiService weatherApiService = new WeatherApiService();

                        CityWeatherDto dataFromOpenWeather = weatherApiService.getDataFromOpenWeather(cityName);
                        CityWeatherDto dataFromWeatherStack = weatherApiService.getDataFromWeatherStack(cityName);
                        CityWeatherDto dataFromWeatherBit = weatherApiService.getDataFromWeatherBit(cityName);

                        CityDataEntity weatherDataEntityFromOw = new CityDataEntity(
                                cityName, WeatherDataEntityMapper.fromCityWeatherDto(dataFromOpenWeather));
                        CityDataEntity weatherDataEntityFromWs = new CityDataEntity(
                                cityName, WeatherDataEntityMapper.fromCityWeatherDto(dataFromWeatherStack));
                        CityDataEntity weatherDataEntityFromWb = new CityDataEntity(
                                cityName, WeatherDataEntityMapper.fromCityWeatherDto(dataFromWeatherBit));

                        DATA_BASE.add(weatherDataEntityFromOw);
                        DATA_BASE.add(weatherDataEntityFromWs);
                        DATA_BASE.add(weatherDataEntityFromWb);
                    }catch(NullPointerException e){
                        System.out.println("No such a location founded - "+cityName);
                    }
                });
    }
}
