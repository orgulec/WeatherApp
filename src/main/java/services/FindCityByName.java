package services;

import api.WeatherApiService;
import api.dto.CityWeatherDto;
import database.CityDataEntity;
import database.WeatherDataEntityMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static database.CityWeatherDb.*;

public class FindCityByName {
    public void serchForCity() {
        System.out.println("Type a name of the city:");
        Scanner sc2 = new Scanner(System.in);
        String newCity = sc2.nextLine();

        List<CityDataEntity> listOfCityDataEntities = new ArrayList<>();

        if (checkIfDbContainsCityName(newCity)) {
            listOfCityDataEntities.addAll(
                    getCitiesFromDb(newCity)
            );
            System.out.println("Getting city from DB...");
        } else {
            try {

                WeatherApiService weatherApiService = new WeatherApiService();

                CityWeatherDto dataFromOpenWeather = weatherApiService.getDataFromOpenWeather(newCity);
                CityWeatherDto dataFromWeatherStack = weatherApiService.getDataFromWeatherStack(newCity);
                CityWeatherDto dataFromWeatherBit = weatherApiService.getDataFromWeatherBit(newCity);

                CityDataEntity weatherDataEntityFromOw = new CityDataEntity(
                        newCity, WeatherDataEntityMapper.fromCityWeatherDto(dataFromOpenWeather));
                CityDataEntity weatherDataEntityFromWs = new CityDataEntity(
                        newCity, WeatherDataEntityMapper.fromCityWeatherDto(dataFromWeatherStack));
                CityDataEntity weatherDataEntityFromWb = new CityDataEntity(
                        newCity, WeatherDataEntityMapper.fromCityWeatherDto(dataFromWeatherBit));

                listOfCityDataEntities.add(weatherDataEntityFromOw);
                listOfCityDataEntities.add(weatherDataEntityFromWs);
                listOfCityDataEntities.add(weatherDataEntityFromWb);

                System.out.println("Getting city from API...");
            }catch (NullPointerException e){
                System.out.println("No such location founded.");
            }
        }
        if(!listOfCityDataEntities.isEmpty())
            showAverageWeatherData(listOfCityDataEntities);

    }

    private static void showAverageWeatherData(List<CityDataEntity> listOfCityDataEntities) {
        float iterator = listOfCityDataEntities.size();
        var result = new Object() {
            String name = "";
            LocalDateTime date;
            Float temperature = 0f;
            Float pressure = 0f;
            Float windSpeed = 0f;
            Float cloudcover = 0f;
        };

        listOfCityDataEntities.forEach(
                ct -> {
                    result.name = ct.getCityName();
                    result.date = ct.getWeatherDataEntity().getDate();
                    result.temperature += ct.getWeatherDataEntity().getTemperature();
                    result.pressure += ct.getWeatherDataEntity().getPressure();
                    result.windSpeed += ct.getWeatherDataEntity().getWindSpeed();
                    result.cloudcover += ct.getWeatherDataEntity().getCloudcover();
                }
        );

        result.temperature = result.temperature/iterator;
        result.pressure = result.pressure/iterator;
        result.windSpeed = result.windSpeed/iterator;
        result.cloudcover = result.cloudcover/iterator;

        String message = """
                -------------------
                Averange Weather Data:
                City name:      [%s]
                City date:      [%s]
                City temp:      [%s] C
                City pressure:  [%s] hPa
                City wind:      [%s] m/s
                City clouds:    [%s] percent
                
                (Nr of used APIs: [%s])
                """.formatted(
                result.name,
                result.date,
                result.temperature,
                result.pressure,
                result.windSpeed,
                result.cloudcover,
                iterator);
        System.out.println(message);
    }

}
