package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientService {

    private static HttpClient client = HttpClient.newHttpClient();
    public static void getWeather(){
        var request = HttpRequest
                .newBuilder()   //wzorzec projektowy
                .uri(URI.create("https://api.openweathermap.org/data/2.5/weather?appid=716238e6166ce6e1315daf3232959cd3&q=Warsaw&units=metric")) //ścieżka dostępu do API
                .GET()          //POST / PUT / DELETE itd.
                .header("Accept","application/json")
                .build();

        try {
            var bodyAsString = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            System.out.println(bodyAsString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
