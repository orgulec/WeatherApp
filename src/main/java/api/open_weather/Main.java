package api.open_weather;

class Main {
    final Float temp;
    final Float pressure;

    public Main(Float temp, Float pressure) {
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
