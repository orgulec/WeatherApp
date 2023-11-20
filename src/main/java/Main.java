import api.HttpClientService;

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
                case "Y" -> HttpClientService.getWeather(); //System.out.println("TODO: add some weather data");
                default -> System.out.println("Error: Invalid input!");
            }
        }

    }

}
