package handlers;

import api.open_weather.CityOwResponse;
import api.weatherstack.CityWsResponse;
import database.CityDataEntity;
import database.WeatherDataEntity;
import services.ApiWeatherService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static database.CityWeatherDb.*;

public class FindCityByNameHandler {
    public void handle() {
        System.out.println("Type a name of the city:");
        Scanner sc2 = new Scanner(System.in);
        String newCity = sc2.nextLine();

        List<CityDataEntity> listOfCityDataEntities = new ArrayList<>();

        if (checkIfDbContainsCityName(newCity)) {
            listOfCityDataEntities.addAll(
                    getCitiesFromDb(newCity)
            );
            System.out.println("Getting cities from DB...");
        } else {
           WeatherDataEntity wsApiWeather =
                    new WeatherDataEntity((CityWsResponse)
                            new ApiWeatherService().getWeatherFromWeatherApi(newCity, CityWsResponse.class));
            CityDataEntity wsCityWeather = new CityDataEntity(newCity, wsApiWeather);

            WeatherDataEntity owApiWeather =
                    new WeatherDataEntity((CityOwResponse)
                            new ApiWeatherService().getWeatherFromWeatherApi(newCity, CityOwResponse.class));
            CityDataEntity owCityWeather = new CityDataEntity(newCity, owApiWeather);
            listOfCityDataEntities.add(wsCityWeather);
            listOfCityDataEntities.add(owCityWeather);
            System.out.println("Getting cities from API...");
        }

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
        };

        listOfCityDataEntities.forEach(
                ct -> {
                    result.name = ct.getCityName();
                    result.date = ct.getWeatherDataEntity().getDate();
                    result.temperature += ct.getWeatherDataEntity().getTemperature();
                    result.pressure += ct.getWeatherDataEntity().getPressure();
                    result.windSpeed += ct.getWeatherDataEntity().getWindSpeed();
                }
        );

        result.temperature = result.temperature/iterator;
        result.pressure = result.pressure/iterator;
        result.windSpeed = result.windSpeed/iterator;

        String message = """
                ---------
                Averange Weather Data:
                City name:      [%s]
                City date:      [%s]
                City temp:      [%s]
                City pressure:  [%s]
                City wind:      [%s]
                (Nr of APIs:    [%s])
                """.formatted(
                result.name,
                result.date,
                result.temperature,
                result.pressure,
                result.windSpeed,
                iterator);
        System.out.println(message+"\n---------");
    }


//    public void showWeatherStatisticsForCity(fromWs){
//        String message = """
//                ---------
//                City name:      [%s]
//                City date:      [%s]
//                City temp:      [%s]
//                City pressure:  [%s]
//                City wind:      [%s]
//                """.formatted(
//                fromWs.getLocation().getName()+" / "+fromOw.getName(),
//                fromWs.getLocation().getLocaltime()+" / "+fromOw.getDt(),
//                fromWs.getCurrent().getTemperature()+" / "+fromOw.getMain().getTemp(),
//                fromWs.getCurrent().getPressure()+" / "+fromOw.getMain().getPressure(),
//                fromWs.getCurrent().getWind_speed()+" / "+fromOw.getWind().getWind())
//                +"---------";
//        System.out.println(message);
//    }
}
