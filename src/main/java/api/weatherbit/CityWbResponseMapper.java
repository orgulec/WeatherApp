package api.weatherbit;

import api.dto.CityWeatherDto;

import java.util.Arrays;
import java.util.List;

class CityWbResponseMapper {

    public static CityWeatherDto fromCityWbResponse(CityWbResponse response){

        List<DataWbElement> list = Arrays.stream(response.data).toList();
        return new CityWeatherDto(
                null,
                list.get(0).getTs(),
                list.get(0).getApp_temp(),
                list.get(0).getWind_spd(),
                list.get(0).getPres(),
                list.get(0).getClouds()
        );
    }
}
