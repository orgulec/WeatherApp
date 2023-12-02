package api.weatherbit;

import api.HttpClientService;
import api.dto.CityWeatherDto;

public class WeatherBitApiService {

    public CityWeatherDto getData(String cityName) {

        String baseUrl = "http://api.weatherbit.io/v2.0/current";
        String appIsQuery = "key=d74a3b255a1d411bae7fa4029a91e696";
        String cityNameQuery = "city=" + cityName;
        String unitsQuery = "units=metrics";

        String openWeatherUrl = baseUrl + "?" + appIsQuery + "&" + cityNameQuery + "&" + unitsQuery;
        var httpClientService = new HttpClientService<CityWbResponse>();

        CityWbResponse response = httpClientService.getWeather(
                openWeatherUrl,
                CityWbResponse.class
        );

        return CityWbResponseMapper.fromCityWbResponse(response);
    }


}
