package api.open_weather;

public class Wind {
    private final Float speed;

    public Wind(Float wind) {
        this.speed = wind;
    }

    public Float getWind() {
        return speed;
    }

}
