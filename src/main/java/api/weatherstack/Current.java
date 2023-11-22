package api.weatherstack;

public class Current {
    Float temperature;
    Float wind_speed;
    Float pressure;

    public Current(Float temperature, Float wind_speed, Float pressure) {
        this.temperature = temperature;
        this.wind_speed = wind_speed;
        this.pressure = pressure;
    }

    public Float getTemperature() {
        return temperature;
    }

    public Float getWind_speed() {
        return wind_speed;
    }

    public Float getPressure() {
        return pressure;
    }
}
