package api;

import java.net.URI;
import java.net.http.HttpRequest;

public class HttpClientService {
    public static void getWeather(){
        var request = HttpRequest
                .newBuilder()   //wzorzec projektowy
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3")) //ścieżka dostępu do API
                .GET()          //POST / PUT / DELETE itd.
                .header("Accept","application/json")
                .build();
    }


}
