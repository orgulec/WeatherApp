package services;

import api.HttpClientService;
import api.open_weather.CityOwResponse;
import api.weatherstack.CityWsResponse;

public class ApiWeatherService<T> {

    public T getWeatherFromWeatherApi(String cityName, Class<T> responseClass) {
        String baseUrl="";
        String appIsQuery="";
        String cityNameQuery="";
        String unitsQuery="";

        if (responseClass.equals(CityOwResponse.class)) {
            baseUrl = "https://api.openweathermap.org/data/2.5/weather?";
            appIsQuery = "appid=716238e6166ce6e1315daf3232959cd3";
            cityNameQuery = "q=" + cityName;
            unitsQuery = "units=metric";
        } else if(responseClass.equals(CityWsResponse.class)){
            baseUrl = "http://api.weatherstack.com/current";
            appIsQuery = "access_key=0265d146105fc401377ecbfca92e4fb0";
            cityNameQuery = "query=" + cityName;
            unitsQuery = "";
        }

        String openWeatherUrl = baseUrl + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;

        var httpClientService = new HttpClientService<T>();
        T response = httpClientService.getWeather(openWeatherUrl, responseClass);

        try {
            return response;
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
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

    public CityWsResponse getWeatherFromWeatherStack(String cityName) {
//        String weatherStackUrl = "http://api.weatherstack.com/current?access_key=0265d146105fc401377ecbfca92e4fb0&query=Warsaw";
        String baseUrl = "http://api.weatherstack.com/current";
        String appIsQuery = "access_key=0265d146105fc401377ecbfca92e4fb0";
        String cityNameQuery = "query=" + cityName;
        String unitsQuery = "";

        String weatherStackUrl = baseUrl + appIsQuery + "&" + cityNameQuery;

        var httpClientService = new HttpClientService<CityWsResponse>();
        final CityWsResponse response = httpClientService.getWeather(weatherStackUrl, CityWsResponse.class);

        try {
            return response;
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }


}
