package services;

import api.HttpClientService;
import api.open_weather.CityOwResponse;
import api.weatherstack.CityWsResponse;

public class WeatherService {

    public CityOwResponse getWeatherFromOpenWeather(String cityName) {
//        String openWeatherUrl = "https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q=Warsaw&units=metric";
        String baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
        String appIsQuery = "appid=716238e6166ce6e1315daf3232959cd3";
        String cityNameQuery = "q=" + cityName;
        String unitsQuery = "units=metric";

        String openWeatherUrl = baseUrl + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;

        var httpClientService = new HttpClientService<CityOwResponse>();
        CityOwResponse response = httpClientService.getWeather(openWeatherUrl, CityOwResponse.class);

        try {
            return response;
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }

    public CityWsResponse getWeatherFromWeatherStack() {
        String weatherStackUrl = "http://api.weatherstack.com/current?access_key=0265d146105fc401377ecbfca92e4fb0&query=Warsaw";

        var httpClientService = new HttpClientService<CityWsResponse>();
        final CityWsResponse response = httpClientService.getWeather(weatherStackUrl, CityWsResponse.class);

        try {
            return response;
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }


}
