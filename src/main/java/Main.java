
import services.FindCityByName;
import java.util.Scanner;

import static services.AutomaticDataBaseGenerator.*;
import static services.FindCityByName.findAndRemoveCityFromDb;

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
                case "1" -> {
                    new FindCityByName().searchForCity();
                    isFirstRun = true;
                }
                case "2" -> {
                    if(DATA_BASE.count()>0) DATA_BASE.printAllDataEntities();
                    else System.out.println("Database is empty!");
                    isFirstRun = true;
                }
                case "3" -> {
                    DATA_BASE.clear();
                    generateBasicDataBaseAtStart();
                    isFirstRun = true;
                }
                case "4" -> {
                    findAndRemoveCityFromDb();
                    isFirstRun = true;
                }
                case "5" -> {
                    if(DATA_BASE.count()>0) {
                        DATA_BASE.clear();
                        System.out.println("Database is now empty!");
                    }
                    else System.out.println("Database is already empty!");
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
            System.out.println("""
                    ----------------------
                    WELCOME in Avarage Weather App!
                    Press:
                      1. to input a new city name into database
                      2. to print city database
                      3. to reload basic database
                      4. to remove city from database
                      5. to clean database
                      
                      X to quit
                    ----------------------
                    """);
            isFirstRun = false;
        }
        return isFirstRun;
    }
}
