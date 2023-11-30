package api.weatherstack;

import api.dto.CityWeatherDto;

class CityWsResponseMapper {

    public static CityWeatherDto fromCityWsResponse(CityWsResponse response) {
        return new CityWeatherDto(
                null,
                response.getLocation().getLocaltime(),
                response.getCurrent().getTemperature(),
                response.getCurrent().getWind_speed(),
                response.getCurrent().getPressure(),
                response.getCurrent().getCloudcover()
        );
    }
}
