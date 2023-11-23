package api.dto;

import api.open_weather.OpenWeatherService;
import api.weatherstack.WeatherStackService;

import java.time.LocalDateTime;

public class CityWeatherDataResponse {
    //klasa do ładowania danych z Jsona
    //nazwy pól muszą pokrywać się z nazwami pól w obiekcie Json!!!
    private final String cityName;
    private final LocalDateTime date;

    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;


    public CityWeatherDataResponse(OpenWeatherService weatherService) {
        this.cityName = weatherService.getCityName();
        this.date = weatherService.getDate();
        this.temperature = weatherService.getTemperature();
        this.windSpeed = weatherService.getWindSpeed();
        this.pressure = weatherService.getPressure();
    }
    public CityWeatherDataResponse(WeatherStackService weatherService) {
        this.cityName = weatherService.getCityName();
        this.date = weatherService.getDate();
        this.temperature = weatherService.getTemperature();
        this.windSpeed = weatherService.getWindSpeed();
        this.pressure = weatherService.getPressure();
    }

    public String getCityName() {
        return cityName;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getWindSpeed() {
        return windSpeed;
    }

    public Float getPressure() {
        return pressure;
    }

    @Override
    public String toString() {
        return "CityWeatherDataResponse{" +
                "cityName='" + cityName + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                '}';
    }
}
