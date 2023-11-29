package api.weatherbit;

import java.time.LocalDateTime;

public class DataWbElement {
    private final String city_name;
    private final LocalDateTime ts;
    private final Float app_temp;
    private final Float wind_spd;
    private final Float pres;
    private final Float clouds;

    public DataWbElement(String city_name, LocalDateTime ts, Float app_temp, Float wind_spd, Float pres, Float clouds) {
        this.city_name = city_name;
        this.ts = ts;
        this.app_temp = app_temp;
        this.wind_spd = wind_spd;
        this.pres = pres;
        this.clouds = clouds;
    }

    public String getCity_name() {
        return city_name;
    }

    public LocalDateTime getTs() {
        return ts;
    }

    public Float getApp_temp() {
        return app_temp;
    }

    public Float getWind_spd() {
        return wind_spd;
    }

    public Float getPres() {
        return pres;
    }

    public Float getClouds() {
        return clouds;
    }
}
