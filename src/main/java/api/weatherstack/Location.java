package api.weatherstack;

import java.time.LocalDateTime;

public class Location {
    final String name;
    final LocalDateTime localtime_epoch;

    public Location(String name, LocalDateTime localtime_epoch) {
        this.name = name;
        this.localtime_epoch = localtime_epoch;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLocaltime() {
        return localtime_epoch;
    }
}
