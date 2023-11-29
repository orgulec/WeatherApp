package api.weatherbit;

public class WeatherBitDtoMapper {


    public WeatherBitDto map(DataWbElement dataWbElement){
        return new WeatherBitDto(dataWbElement.getCity_name(),dataWbElement.getTs(),dataWbElement.getApp_temp(),dataWbElement.getWind_spd(), dataWbElement.getPres(), dataWbElement.getClouds());
    }

}
