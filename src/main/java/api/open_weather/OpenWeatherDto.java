package api.open_weather;

import java.time.LocalDateTime;

public class OpenWeatherDto {

    private String cityName;
    private LocalDateTime date;

    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    public OpenWeatherDto(CityOwResponse cityOwResponse) {
        this.cityName = cityOwResponse.getName();
        this.date = cityOwResponse.getDt();
        this.temperature = cityOwResponse.getMain().temp;
        this.windSpeed = cityOwResponse.getWind().getWind();
        this.pressure = cityOwResponse.main.getPressure();
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
        return "OpenWeatherDto{" +
                "cityName='" + cityName + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", pressure=" + pressure +
                '}';
    }
}
