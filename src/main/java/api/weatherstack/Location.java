package api.weatherstack;

import java.time.LocalDateTime;

public class Location {
    String name;
    LocalDateTime localtime;

    public Location(String name, LocalDateTime localtime) {
        this.name = name;
        this.localtime = localtime;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getLocaltime() {
        return localtime;
    }
}
