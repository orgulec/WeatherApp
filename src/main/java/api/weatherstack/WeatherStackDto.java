package api.weatherstack;

import java.time.LocalDateTime;

class WeatherStackDto {
    private final String cityName;
    private final LocalDateTime date;
    private final Float temperature;
    private final Float windSpeed;
    private final Float pressure;
    private final Float cloudcover;

    public WeatherStackDto(CityWsResponse cityWsResponse) {
        this.cityName = cityWsResponse.getLocation().getName();
        this.date = cityWsResponse.getLocation().getLocaltime();
        this.temperature = cityWsResponse.getCurrent().getTemperature();
        this.windSpeed = cityWsResponse.getCurrent().getWind_speed();
        this.pressure = cityWsResponse.getCurrent().getPressure();
        this.cloudcover = cityWsResponse.getCurrent().getCloudcover();
    }
}
