package api.open_weather;

public class Main {
    Float temp;
    Float pressure;

    private Main(Float temp, Float pressure) {
        this.temp = temp;
        this.pressure = pressure;
    }

    public Float getTemp() {
        return temp;
    }

    public Float getPressure() {
        return pressure;
    }

}
