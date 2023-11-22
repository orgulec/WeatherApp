import api.open_weather.CityOwResponse;
import services.ApiWeatherService;
import services.WeatherService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
                    final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather("Warsaw");
                    System.out.println("City name: " + weatherFromOpenWeather.getName());
                    System.out.println("City date: " + weatherFromOpenWeather.getDt());
                    System.out.println("City temp: " + weatherFromOpenWeather.getMain().getTemp());
                    System.out.println("City pressure: " + weatherFromOpenWeather.getMain().getPressure());
                    System.out.println("City wind: " + weatherFromOpenWeather.getWind().getWind());
                }
                case "A" -> {
                    showInputCityNameMenu();
                }
                default -> System.out.println("Error: Invalid input!");
            }
        }

    }

    private static boolean showWelcomeMenu(boolean isFirstRun) {
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
        return isFirstRun;
    }

    private static void showInputCityNameMenu() {
        System.out.println("Type a name of the city:");
        Scanner sc2 = new Scanner(System.in);
        String newCity = sc2.nextLine();
//        final CityOwResponse weatherFromOpenWeatherWithNewCity = new WeatherService().getWeatherFromOpenWeather(newCity);
        final CityOwResponse weatherFromOpenWeatherWithNewCity = (CityOwResponse) new ApiWeatherService().getWeatherFromWeatherApi(newCity,CityOwResponse.class);
        String message = """
                ---------
                City name:      [%s]
                City date:      [%s]
                City temp:      [%s]
                City pressure:  [%s]
                City wind:      [%s]
                """.formatted(
                weatherFromOpenWeatherWithNewCity.getName(),
                weatherFromOpenWeatherWithNewCity.getDt(),
                weatherFromOpenWeatherWithNewCity.getMain().getTemp(),
                weatherFromOpenWeatherWithNewCity.getMain().getPressure(),
                weatherFromOpenWeatherWithNewCity.getWind().getWind());
        System.out.println(message);
    }

}