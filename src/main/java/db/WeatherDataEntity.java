package db;

import java.time.LocalDate;

public class WeatherDataEntity {
    private Long id;
    private Long cityId;

    private LocalDate date;
    private Long temperature;
    private Long windSpeed;
    private Long pressure;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public Long getTemperature() {
        return temperature;
    }
    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }
    public Long getWindSpeed() {
        return windSpeed;
    }
    public void setWindSpeed(Long windSpeed) {
        this.windSpeed = windSpeed;
    }
    public Long getPressure() {
        return pressure;
    }
    public void setPressure(Long pressure) {
        this.pressure = pressure;
    }



}
