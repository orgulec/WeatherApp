package handlers;

import api.open_weather.CityOwResponse;
import api.weatherbit.CityWbResponse;
import api.weatherstack.CityWsResponse;
import database.CityDataEntity;
import database.CityWeatherDb;
import database.WeatherDataEntity;
import services.ApiWeatherService;

import java.util.List;

public class AutomaticDataBaseGenerator {
    public static CityWeatherDb DATA_BASE = new CityWeatherDb();
    public static void generateBasicDataBaseAtStart() {
        System.out.println("\nInitalising Application DB...!");

        final List<String> popularCities = List.of("Warsaw", "Cracow", "Szczecin", "Katowice");//, "Gdansk", "Poznan","Wroclaw","Gdynia");
        popularCities
                .forEach(cityName -> {
                    try {
                        final CityWsResponse resultWs = (CityWsResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityWsResponse.class);
                        CityDataEntity cityDataEntityWs = new CityDataEntity(cityName, new WeatherDataEntity(resultWs));
                        final CityOwResponse resultOw = (CityOwResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityOwResponse.class);
                        CityDataEntity cityDataEntityOw = new CityDataEntity(cityName, new WeatherDataEntity(resultOw));
                        final CityWbResponse resultWb = (CityWbResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityWbResponse.class);
                        CityDataEntity cityDataEntityWb = new CityDataEntity(cityName, new WeatherDataEntity(resultWb));

                        if (DATA_BASE.checkIfDbContainsCityName(cityName)) {
                            cityDataEntityWs = DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntityWs);
                            cityDataEntityOw = DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntityOw);
                        cityDataEntityWb=DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntityWb);
                        }
                        DATA_BASE.add(cityDataEntityWs);
                        DATA_BASE.add(cityDataEntityOw);
                        DATA_BASE.add(cityDataEntityWb);
                    }catch(NullPointerException e){
                        System.out.println("No such a location founded - "+cityName);
                    }
                });
    }
}
