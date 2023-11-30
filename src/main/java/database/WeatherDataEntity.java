package database;


import java.time.LocalDateTime;

public class WeatherDataEntity {
    private Long cityId;
    private final LocalDateTime date;
    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public WeatherDataEntity(Long cityId, LocalDateTime date, Float temperature, Float windSpeed, Float pressure, Float cloudcover) {
        this.cityId = cityId;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.cloudcover = cloudcover;
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
