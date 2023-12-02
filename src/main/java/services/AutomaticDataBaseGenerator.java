package services;

import api.WeatherApiService;
import api.dto.CityWeatherDto;
import database.CityDataEntity;
import database.CityWeatherDb;
import database.WeatherDataEntityMapper;

import java.util.ArrayList;
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
                                ArrayList<CityWeatherDto> apiServiceData = weatherApiService.getData(cityName);

                                apiServiceData.forEach(getService -> {
                                            CityDataEntity newWeatherDataEntity = new CityDataEntity(cityName,
                                                    WeatherDataEntityMapper.fromCityWeatherDto(getService));
                                            DATA_BASE.add(newWeatherDataEntity);
                                        }
                                );
                            } catch (NullPointerException e) {
                                System.out.println("No such location founded - " + cityName);
                            }
                        }
                );
    }
}
