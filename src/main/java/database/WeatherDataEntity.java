package database;

import api.open_weather.CityOwResponse;
import api.weatherstack.CityWsResponse;
import java.time.LocalDateTime;

public class WeatherDataEntity {
    private Long cityId;
    private LocalDateTime date;
    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    public WeatherDataEntity(CityOwResponse cityOwResponse) {
        this.date = cityOwResponse.getDt();
        this.temperature = cityOwResponse.getMain().getTemp();
        this.windSpeed = cityOwResponse.getWind().getWind();
        this.pressure = cityOwResponse.getMain().getPressure();
    }
    public WeatherDataEntity(CityWsResponse cityWsResponse) {
        this.date = cityWsResponse.getLocation().getLocaltime();
        this.temperature = cityWsResponse.getCurrent().getTemperature();
        this.windSpeed = cityWsResponse.getCurrent().getWind_speed();
        this.pressure = cityWsResponse.getCurrent().getPressure();
    }


    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
/*    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }*/
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public Float getTemperature() {
        return temperature;
    }
    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }
    public Float getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(Float windSpeed) {
        this.windSpeed = windSpeed;
    }
    public Float getPressure() {
        return pressure;
    }
    public void setPressure(Float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return " [Weather:" +
//                " (id) "+ cityId +
                " " + date +
                ", " + temperature +
                ", " + windSpeed +
                ", " + pressure + "] ";
    }
}
