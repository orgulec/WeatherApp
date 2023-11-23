package api.open_weather;

import java.time.LocalDateTime;

public class OpenWeatherService {

    private String cityName;
    private LocalDateTime date;

    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    public OpenWeatherService(CityOwResponse cityOwResponse) {
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
}
