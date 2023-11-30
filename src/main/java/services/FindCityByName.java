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
            getFoundedCityNameFromDb(listOfCityDataEntities, newCity);
        }
        else {
            getCityNameFromApi(newCity, listOfCityDataEntities);
        }

        if(!listOfCityDataEntities.isEmpty())
            showAverageWeatherData(listOfCityDataEntities);
        else
            System.out.println("No data founded!");

    }

    private static void getFoundedCityNameFromDb(List<CityDataEntity> listOfCityDataEntities, String newCity) {
        listOfCityDataEntities.addAll(
                getCitiesFromDb(newCity)
        );
        System.out.println("Getting city from DB...");
    }

    private static void getCityNameFromApi(String newCity, List<CityDataEntity> listOfCityDataEntities) {
        try {

            WeatherApiService weatherApiService = new WeatherApiService();

            CityWeatherDto[] dtoArray = new CityWeatherDto[]{
                    weatherApiService.getDataFromOpenWeather(newCity),
                    weatherApiService.getDataFromWeatherStack(newCity),
                    weatherApiService.getDataFromWeatherBit(newCity)
            };

            for (CityWeatherDto cityWeatherDto : dtoArray) {
                CityDataEntity newWeatherDataEntity = new CityDataEntity(
                        newCity, WeatherDataEntityMapper.fromCityWeatherDto(cityWeatherDto));
                listOfCityDataEntities.add(newWeatherDataEntity);
            }


            System.out.println("Getting city from API...");
        }catch (NullPointerException e){
            System.out.println("No such location founded.");
        }
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
