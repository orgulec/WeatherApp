package handlers;

import api.weatherstack.CityWsResponse;
import database.CityDataEntity;
import database.CityWeatherDb;
import database.WeatherDataEntity;
import services.ApiWeatherService;

import java.util.List;

public class AutomaticDataBaseGenerator {
    public static final CityWeatherDb DATA_BASE = new CityWeatherDb();
    public static void generateBasicDataBaseAtStart() {
        System.out.println("\nInitalising Application DB...!");

        final List<String> popularCities = List.of("Warsaw", "Cracow", "Szczecin", "Katowice", "Gdansk", "Bydgoszcz","Poznan","Wroclaw","Gdynia");
        popularCities
                .forEach(cityName -> {
                    final CityWsResponse resultWs = (CityWsResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityWsResponse.class);
                    CityDataEntity cityDataEntityWs = new CityDataEntity(cityName, new WeatherDataEntity(resultWs));
                    final CityWsResponse resultOw = (CityWsResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityWsResponse.class);
                    CityDataEntity cityDataEntityOw = new CityDataEntity(cityName, new WeatherDataEntity(resultOw));

                    if(DATA_BASE.checkIfDbContainsCityName(cityName)){
                        cityDataEntityWs=DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntityWs);
                        cityDataEntityOw=DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntityOw);
                    }
                    DATA_BASE.add(cityDataEntityWs);
                    DATA_BASE.add(cityDataEntityOw);

                });
    }
}
