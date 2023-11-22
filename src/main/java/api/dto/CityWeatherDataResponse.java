package api.dto;

import java.time.LocalDateTime;

public class CityWeatherDataResponse {
    //klasa do ładowania danych z Jsona
    //nazwy pól muszą pokrywać się z nazwami pól w obiekcie Json!!!
    private String cityName;
    private LocalDateTime date;

    private Float temperature;
    private Float windSpeed;
    private Float pressure;

    private CityWeatherDataResponse(String cityName, LocalDateTime date, Float temperature, Float windSpeed, Float pressure) {
        this.cityName = cityName;
        this.date = date;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

/*    public String getCityName() {
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
    }*/
}
