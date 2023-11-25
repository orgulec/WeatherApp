
import handlers.FindCityByNameHandler;
import java.util.Scanner;

import static handlers.AutomaticDataBaseGenerator.*;

public class Main {
    public static void main(String[] args) {
        generateBasicDataBaseAtStart();

        var isRunning = true;
        var isFirstRun = true;

        while (isRunning) {
            isFirstRun = showWelcomeMenu(isFirstRun);
            Scanner sc = new Scanner(System.in);
            String userInput = sc.nextLine();

            switch (userInput.toUpperCase()) {
                case "X" -> {
                    System.out.println("Good Bye!");
                    isRunning = false;
                }
                case "2" -> {
                    DATA_BASE.printAllDataEntities();
                    isFirstRun = true;
               }
                case "1" -> {
                    new FindCityByNameHandler().handle();
                    isFirstRun = true;
                }
                default -> {
                    System.out.println("Invalid input!");
                    isFirstRun = true;
                }
            }
        }
    }

    private static boolean showWelcomeMenu(boolean isFirstRun) {
        if (isFirstRun) {
            System.out.println("\n"+"""
                    ----------------------
                    WELCOME in Avarage Weather App!
                    Press:
                    1. to input a new city name into database
                    2. to print city database
                    X to quit
                    ----------------------
                    """);
            isFirstRun = false;
        }
        return isFirstRun;
    }
}
