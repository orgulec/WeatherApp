package api.weatherstack;

class CityWsResponse {
    private final Current current;
    private final Location location;

    public CityWsResponse(Current current, Location location) {
        this.current = current;
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public Location getLocation() {
        return location;
    }

}


/*
{"request":
    {
    "type":"City",
    "query":"New York, United States of America",
    "language":"en",
    "unit":"m"
    },
"location":
    {
    "name":"New York",        //////////////
    "country":"United States of America",
    "region":"New York",
    "lat":"40.714",
    "lon":"-74.006",
    "timezone_id":"America\/New_York",
    "localtime":"2023-11-22 13:41",       ////////////
    "localtime_epoch":1700660460,
    "utc_offset":"-5.0"
    },
"current":
    {
    "observation_time":"06:41 PM",
    "temperature":12,      //////////////
    "weather_code":116,
    "weather_icons":["https:\/\/cdn.worldweatheronline.com\/images\/wsymbols01_png_64\/wsymbol_0002_sunny_intervals.png"]
    ,"weather_descriptions":["Partly cloudy"],
    "wind_speed":15,      //////////////
    "wind_degree":300,
    "wind_dir":"WNW",
    "pressure":1005,      //////////////
    "precip":0,
    "humidity":71,
    "cloudcover":75,
    "feelslike":10,
    "uv_index":4,
    "visibility":16,
    "is_day":"yes"
    }
}
 */