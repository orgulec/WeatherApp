package api.weatherstack;

import java.time.LocalDateTime;

public class WeatherStackDto {
    private String cityName;
    private LocalDateTime date;

    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    public WeatherStackDto(CityWsResponse cityWsResponse) {
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
        return "WeatherStackDto{" +
                "cityName='" + cityName + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                '}';
    }
}
