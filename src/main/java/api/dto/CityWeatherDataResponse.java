package api.dto;

import api.open_weather.CityOwResponse;
import api.open_weather.OpenWeatherDto;
import api.weatherstack.CityWsResponse;
import api.weatherstack.WeatherStackDto;

import java.time.LocalDateTime;

public class CityWeatherDataResponse {
    //klasa do ładowania danych z Jsona
    //nazwy pól muszą pokrywać się z nazwami pól w obiekcie Json!!!
    private final String cityName;
    private final LocalDateTime date;

    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;


    public CityWeatherDataResponse(CityOwResponse cityOwResponse) {
        this.cityName = cityOwResponse.getName();
        this.date = cityOwResponse.getDt();
        this.temperature = cityOwResponse.getMain().getTemp();
        this.windSpeed = cityOwResponse.getWind().getWind();
        this.pressure = cityOwResponse.getMain().getPressure();
    }
    public CityWeatherDataResponse(CityWsResponse cityWsResponse) {
        this.cityName = cityWsResponse.getLocation().getName();
        this.date = cityWsResponse.getLocation().getLocaltime();
        this.temperature = cityWsResponse.getCurrent().getTemperature();
        this.windSpeed = cityWsResponse.getCurrent().getWind_speed();
        this.pressure = cityWsResponse.getCurrent().getPressure();
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
