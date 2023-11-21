import api.HttpClientService;
import api.open_weather.CityOwResponse;
import services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            if (isFirstRun) {
                System.out.println("""
                        ----------------------
                        WELCOME!
                        type X to quit
                        type Y to get a weather stats
                        ----------------------
                        """);
                isFirstRun = false;
            }
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
                    final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather();
                    System.out.println("City name: " + weatherFromOpenWeather.getName());
                }
                default -> System.out.println("Error: Invalid input!");
            }
        }

    }

}


/*
    Techniczna specyfikacja aplikacji:
    1. Architekura:
    DDD / *Architektura warstwowa / Arch. heksagonalna
    2. Wersja Javy
    Java 17
    3. Przechowywanie danych
    Map<> / PostgreSQL + Hibernate (+ Spring)
    4. Zewnetrzne dane
    http
    ---
    MVP
    Wymagań biznesowcyh
    - chcemy pobierać dane z wielu miast w EU
        - wybrać api zewnętrzne
        - jakoś komunikować z api
    - baza danych (prosta wersja)
        - cityName
        - date
        - temperature
        - windSpeed
        - pressure
    - chcemy uśredniać wyniki
    - chcemy optymalizować pracę aplikacji poprzez cache
        - podczas startu aplikacji pobieramy X miast
 */