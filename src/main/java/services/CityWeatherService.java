package services;

import api.CityWeatherDataResponse;
import api.HttpClientService;
import api.open_weather.CityOwResponse;
import db.CityDataEntity;
import db.CityWeatherDb;
import db.WeatherDataEntity;

public class CityWeatherService {

    public static CityOwResponse getWeatherFromOpenWeatherWithNewCity(String city){
        String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q="+city+"&units=metric";
        var httpClientService = new HttpClientService<CityOwResponse>();
        final CityOwResponse response = httpClientService.getWeather(openWeatherUrl, CityOwResponse.class);

        return response;
    }
    public static void addCityWeatherIntoDataBase(CityOwResponse city){

        CityWeatherDataResponse cityWeatherDataResponse = new CityWeatherDataResponse(
                city.getName(),
                city.getDt(),
                city.getMain().getTemp(),
                city.getWind().getWind(),
                city.getMain().getPressure());

        CityDataEntity cityDataEntity = new CityDataEntity();
        cityDataEntity.setName(cityWeatherDataResponse.getCityName());
//        cityDataEntity.setId(city.);
        cityDataEntity.setName(cityWeatherDataResponse.getCityName());

        CityWeatherDb cityWeatherDb = new CityWeatherDb();
        WeatherDataEntity weatherDataEntity = new WeatherDataEntity();
//        weatherDataEntity.setCityId(cityOwR.);
    }

}
