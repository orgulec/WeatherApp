package api.open_weather;

import api.dto.CityWeatherDto;

class CityOwResponseMapper {
	
	public static CityWeatherDto fromCityOwResponse(CityOwResponse response) {
		return new CityWeatherDto(
				null,
				response.getDt(),
				response.getMain().temp,
				response.getWind().getSpeed(),
				response.getMain().pressure,
				response.getClouds().getAll()
		);
	}
	
}
