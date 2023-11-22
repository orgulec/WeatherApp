import api.HttpClientService;
import api.open_weather.CityOwResponse;
import services.WeatherService;

import java.util.Scanner;

import static services.CityWeatherService.getWeatherFromOpenWeatherWithNewCity;

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
                        type A to input a new city name into database
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
                    System.out.println("City date: " + weatherFromOpenWeather.getDt());
                    System.out.println("City temp: " + weatherFromOpenWeather.getMain().getTemp());
                    System.out.println("City pressure: " + weatherFromOpenWeather.getMain().getPressure());
                    System.out.println("City wind: " + weatherFromOpenWeather.getWind().getWind());
                }
                case "A" -> {
                    System.out.println("Type a name of the city:");
                    String newCity = sc.nextLine();
                    CityOwResponse weatherFromOpenWeatherWithNewCity = getWeatherFromOpenWeatherWithNewCity(newCity);

                    System.out.println("City name: " + weatherFromOpenWeatherWithNewCity.getName());
                    System.out.println("City date: " + weatherFromOpenWeatherWithNewCity.getDt());
                    System.out.println("City temp: " + weatherFromOpenWeatherWithNewCity.getMain().getTemp());
                    System.out.println("City pressure: " + weatherFromOpenWeatherWithNewCity.getMain().getPressure());
                    System.out.println("City wind: " + weatherFromOpenWeatherWithNewCity.getWind().getWind());
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