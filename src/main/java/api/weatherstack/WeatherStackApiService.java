package api.weatherstack;

import api.HttpClientService;
import api.dto.CityWeatherDto;

public class WeatherStackApiService {

    public CityWeatherDto getData(String cityName) {

        String baseUrl = "http://api.weatherstack.com/current";
        String appIsQuery = "access_key=0265d146105fc401377ecbfca92e4fb0";
        String cityNameQuery = "query=" + cityName;
        String unitsQuery = "";

        String openWeatherUrl = baseUrl + "?" + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;
        var httpClientService = new HttpClientService<CityWsResponse>();

        CityWsResponse response = httpClientService.getWeather(
                openWeatherUrl,
                CityWsResponse.class
        );

        return CityWsResponseMapper.fromCityWsResponse(response);
    }
}
