package api.weatherbit;

import java.time.LocalDateTime;

import static java.lang.String.valueOf;

class WeatherBitDto {
    private final String cityName;
    private final LocalDateTime date;
    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public WeatherBitDto(String cityName, LocalDateTime date, Float temperature, Float windSpeed, Float pressure, Float cloudcover) {
        this.cityName = cityName;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.cloudcover = cloudcover;
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

    public Float getCloudcover() {
        return cloudcover;
    }
}
