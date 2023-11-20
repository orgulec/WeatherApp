package api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class HttpClientService<T> {

    private static HttpClient client = HttpClient.newHttpClient();
    public T getWeather(String url, Class<T> responseClass){
        var request = HttpRequest
                .newBuilder()   //wzorzec projektowy
                .uri(URI.create(url)) //ścieżka dostępu do API
                .GET()          //POST / INPUT / DELETE itd.
                .header("Accept","application/json")    //informacje dodatkowe umieszczone poza url
                .build();

        try {
            var bodyAsString = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

            final Gson gson = new GsonBuilder().registerTypeAdapter(
                    LocalDateTime.class,
                    new JsonDeserializer<LocalDateTime>() {
                        @Override   //dla różnych API trzeba będzie zmieniać ten sposób pobierania daty!!!
                        public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                            var dateTimeJson = json.getAsJsonPrimitive().getAsLong();
                            return LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeJson), ZoneId.systemDefault());
                        }
                    }
            ).create();

            return gson.fromJson(bodyAsString, responseClass);

//            System.out.println(bodyAsString);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
/*
public class HttpClientService<T> {

    private static HttpClient client = HttpClient.newHttpClient();

    public T getWeather(String url, Class<T> responseClass) {
       var request = HttpRequest
             .newBuilder()
             .uri(URI.create(url))
             .GET()
             .header("Accept", "application/json")
             .build();

       try {
          var bodyAsString = client.send(request, HttpResponse.BodyHandlers.ofString()).body();

          final Gson gson = new GsonBuilder().registerTypeAdapter(
                LocalDateTime.class,
                new JsonDeserializer<LocalDateTime>() {
                   @Override
                   public LocalDateTime deserialize(JsonElement json, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                      var dateTimeJson = json.getAsJsonPrimitive().getAsLong();
                      return LocalDateTime.ofInstant(Instant.ofEpochMilli(dateTimeJson), ZoneId.systemDefault());
                   }
                }
          ).create();

          return gson.fromJson(bodyAsString, responseClass);
       } catch (IOException e) {
          throw new RuntimeException(e);
       } catch (InterruptedException e) {
          throw new RuntimeException(e);
       }
    }

}
 */