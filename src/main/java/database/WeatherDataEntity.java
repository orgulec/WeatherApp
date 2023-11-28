package database;

import api.open_weather.CityOwResponse;
import api.weatherbit.CityWbResponse;
import api.weatherstack.CityWsResponse;

import java.time.LocalDateTime;

public class WeatherDataEntity {
    private Long cityId;
    private final LocalDateTime date;
    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public WeatherDataEntity(CityOwResponse cityOwResponse) {
        this.date = cityOwResponse.getDt();
        this.temperature = cityOwResponse.getMain().getTemp();
        this.windSpeed = cityOwResponse.getWind().getWind();
        this.pressure = cityOwResponse.getMain().getPressure();
        this.cloudcover = cityOwResponse.getClouds().getAll();
    }
    public WeatherDataEntity(CityWsResponse cityWsResponse) {
        this.date = cityWsResponse.getLocation().getLocaltime();
        this.temperature = cityWsResponse.getCurrent().getTemperature();
        this.windSpeed = cityWsResponse.getCurrent().getWind_speed();
        this.pressure = cityWsResponse.getCurrent().getPressure();
        this.cloudcover = cityWsResponse.getCurrent().getCloudcover();
    }
    public WeatherDataEntity(CityWbResponse cityWbResponse) {
        this.date = cityWbResponse.o.getTs();
        this.temperature = cityWbResponse.o.getApp_temp();
        this.windSpeed = cityWbResponse.o.getWind_spd();
        this.pressure = cityWbResponse.o.getPres();
        this.cloudcover = cityWbResponse.o.getClouds();
    }


    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
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

    public Float getCloudcover() {
        return cloudcover;
    }

    @Override
    public String toString() {
        return " [Weather:" +
//                " (id) "+ cityId +
                " " + date +
                ", " + temperature +
                ", " + windSpeed +
                ", " + pressure +
                ", " + cloudcover + "] ";
    }
}
