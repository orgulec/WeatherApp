package api.open_weather;

import api.HttpClientService;
import api.dto.CityWeatherDto;

public class OpenWeatherApiService {

    public CityWeatherDto getData(String cityName) {

        String baseUrl = "https://api.openweathermap.org/data/2.5/weather";
        String appIsQuery = "appid=716238e6166ce6e1315daf3232959cd3";
        String cityNameQuery = "q=" + cityName;
        String unitsQuery = "units=metric";

        String openWeatherUrl = baseUrl + "?" + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;
        var httpClientService = new HttpClientService<CityOwResponse>();

        CityOwResponse response = httpClientService.getWeather(
                openWeatherUrl,
                CityOwResponse.class
        );

        return CityOwResponseMapper.fromCityOwResponse(response);
    }

}
