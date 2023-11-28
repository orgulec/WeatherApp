package api.weatherbit;

import java.time.LocalDateTime;

public class WeatherBitDto {
    private final String cityName;
    private final LocalDateTime date;
    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public WeatherBitDto(CityWbResponse cityWbResponse) {
        this.cityName = cityWbResponse.o.getCity_name();
        this.date = cityWbResponse.o.getTs();
        this.temperature = cityWbResponse.o.getApp_temp();
        this.windSpeed = cityWbResponse.o.getWind_spd();
        this.pressure = cityWbResponse.o.getPres();
        this.cloudcover = cityWbResponse.o.getClouds();
    }
}
