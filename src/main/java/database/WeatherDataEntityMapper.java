package database;

import api.dto.CityWeatherDto;

public class WeatherDataEntityMapper {

    public static WeatherDataEntity fromCityWeatherDto(CityWeatherDto response) {
        return new WeatherDataEntity(
                null,
                response.getDate(),
                response.getTemperature(),
                response.getWindSpeed(),
                response.getPressure(),
                response.getCloudcover()
        );
    }

}
