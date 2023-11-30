package api.weatherstack;

class Current {
    Float temperature;
    Float wind_speed;
    Float pressure;
    Float cloudcover;

    public Current(Float temperature, Float wind_speed, Float pressure, Float cloudcover) {
        this.temperature = temperature;
        this.wind_speed = wind_speed;
        this.pressure = pressure;
        this.cloudcover = cloudcover;
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

    public Float getCloudcover() {
        return cloudcover;
    }
}
