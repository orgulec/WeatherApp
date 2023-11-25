package api.open_weather;

import java.time.LocalDateTime;

public class OpenWeatherDto {

    private final String cityName;
    private final LocalDateTime date;

    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public OpenWeatherDto(CityOwResponse cityOwResponse) {
        this.cityName = cityOwResponse.getName();
        this.date = cityOwResponse.getDt();
        this.temperature = cityOwResponse.getMain().temp;
        this.windSpeed = cityOwResponse.getWind().getWind();
        this.pressure = cityOwResponse.main.getPressure();
        this.cloudcover = cityOwResponse.getClouds().getAll();
    }

}
