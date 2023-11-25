
import api.weatherstack.CityWsResponse;
import database.CityDataEntity;
import database.CityWeatherDb;
import database.WeatherDataEntity;
import handlers.FindCityByNameHandler;
import services.ApiWeatherService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static final CityWeatherDb DATA_BASE = new CityWeatherDb();
    public static void main(String[] args) {

        generateBasicDataBaseAtStart();

        var isRunning = true;
        var isFirstRun = true;
        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput) {
                case "X" -> isRunning = false;
                case "Y" -> {
//                    final CityOwResponse weatherFromOpenWeather = new WeatherService().getWeatherFromOpenWeather("Warsaw");
//                    System.out.println("City name: " + weatherFromOpenWeather.getName());
//                    System.out.println("City date: " + weatherFromOpenWeather.getDt());
//                    System.out.println("City temp: " + weatherFromOpenWeather.getMain().getTemp());
//                    System.out.println("City pressure: " + weatherFromOpenWeather.getMain().getPressure());
//                    System.out.println("City wind: " + weatherFromOpenWeather.getWind().getWind());
                }
                case "A" -> {
                    new FindCityByNameHandler().handle();
                }
                default -> System.out.println("Error: Invalid input!");
            }
        }

    }

    private static void generateBasicDataBaseAtStart() {
        System.out.println("Initalizing Application...!");

        final List<String> popularCities = List.of("Warsaw", "Cracow", "Szczecin", "Katowice", "Gdansk", "Bydgoszcz","Poznan","Wroclaw","Gdynia");
        popularCities
                .forEach(cityName -> {
                    final CityWsResponse result = (CityWsResponse) new ApiWeatherService().getWeatherFromWeatherApi(cityName, CityWsResponse.class);
                    final WeatherDataEntity cityWeatherMapped = new WeatherDataEntity(result);
                    CityDataEntity cityDataEntity = new CityDataEntity(cityName, cityWeatherMapped);

                    if(DATA_BASE.checkIfDbContainsCityName(cityName)){
                        cityDataEntity=DATA_BASE.changeCityIdWhenDoubleCityName(cityDataEntity);
                    }
                    DATA_BASE.add(cityDataEntity);

                });
        DATA_BASE.printAllDataEntities();
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



}

/*
weatherFromOpenWeatherWithNewCity.getName(),
                weatherFromOpenWeatherWithNewCity.getDt(),
                weatherFromOpenWeatherWithNewCity.getMain().getTemp(),
                weatherFromOpenWeatherWithNewCity.getMain().getPressure(),
                weatherFromOpenWeatherWithNewCity.getWind().getWind());
 */