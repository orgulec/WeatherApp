package api.open_weather;

import java.time.LocalDateTime;

public class CityOwResponse {
    Wind wind;
    Main main;
    String name;
    LocalDateTime dt;

    public CityOwResponse(Wind wind, Main main, String name, LocalDateTime dt) {
        this.wind = wind;
        this.main = main;
        this.name = name;
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDt() {
        return dt;
    }

    @Override
    public String toString() {
        return "CityOwResponse{" +
                "wind=" + wind +
                ", main=" + main +
                ", name='" + name + '\'' +
                ", dt=" + dt +
                '}';
    }
}



/*      //JSON - plik przekonwertowany do Javy
{
   "coord":{
      "lon":21.0118,
      "lat":52.2298
   },
   "weather":[
      {
         "id":500,
         "main":"Rain",
         "description":"light rain",
         "icon":"10n"
      },
      {
         "id":601,
         "main":"Snow",
         "description":"snow",
         "icon":"13n"
      }
   ],
   "base":"stations",
   "main":{
      "temp":1.02,      //////////////
      "feels_like":-3.11,
      "temp_min":-0.34,
      "temp_max":2.34,
      "pressure":1006,       ////////////
      "humidity":94
   },
   "visibility":6000,
   "wind":{       ////////////
      "speed":4.12,
      "deg":70
   },
   "snow":{
      "1h":0.51
   },
   "clouds":{
      "all":75
   },
   "dt":1700504090,
   "sys":{
      "type":2,
      "id":2032856,
      "country":"PL",
      "sunrise":1700460278,
      "sunset":1700491116
   },
   "timezone":3600,
   "id":756135,
   "name":"Warsaw",       ////////////
   "cod":200
}
 */