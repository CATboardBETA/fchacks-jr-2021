package williamnelson.personal.src;

import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class CountryByCity {
    public static void main() {
        Scanner scanner = new Scanner(System.in); // Used for user input

        Main.clearScreen(); // Clear screen
        boolean badGameCount = false; // Set if an invalid Game Count was selected.

        System.out.println("Welcome! You will now have to guess the country that owns a given city.");
        int gameCount = 0;
        do {
            System.out.print("How many rounds would you like to play? (You can play more after, but will not be added to your score): ");
            try {
                gameCount = Integer.parseInt(scanner.next());
            } catch (Exception e) {
                System.out.println("Invalid, please try again.");
                badGameCount = true;
            }
        } while (badGameCount);

        Main.clearScreen();
        System.out.println("Starting game...");
        System.out.println();

        int score = 0;
        for (int i = 0; i < gameCount; i++) {
            score += countryFromCity();
        }
        System.out.println("Your score: " + score + "/" + gameCount + " (" + (Float.parseFloat(String.valueOf(score))/Float.parseFloat(String.valueOf(gameCount)) * 100) + "%).");
        System.out.println("Would you like to play again? (Y/n): ");
        String again = scanner.next(); // Read is user wants to go again
        if (again.toLowerCase().equals("y")) {
            main(); // Restarts this function
        } else { // Technically any value of than Y or y will exit, but unimportant.
            System.exit(0); // Exits
        }

    }

    private static int countryFromCity() {
        Scanner scanner = new Scanner(System.in); // User input

        HashMap<String, String> map = new HashMap<>(); // stores city - country pairs.
        map.put("Barcelona", "Spain");
        map.put("Berlin", "Germany");
        map.put("Zurich", "Switzerland");
        map.put("Geneva", "Switzerland");
        map.put("Luanda", "Angola");
        map.put("Oslo", "Norway");
        map.put("Moscow", "Russia");
        map.put("Dubai", "United Arab Emirates");
        map.put("Singapore", "Singapore");
        map.put("Madrid", "Spain");
        map.put("Rome", "Italy");
        map.put("Amsterdam", "Netherlands");
        map.put("Istanbul", "Turkey");
        map.put("Doha", "Qatar");
        map.put("Seoul", "South Korea");
        map.put("Melbourne", "Australia");
        map.put("Montreal", "Canada");
        map.put("Cape Town", "South Africa");
        map.put("Mexico City", "Mexico");
        map.put("Manchester", "England");
        map.put("Buenos Aires", "Argentina");
        map.put("Lisbon", "Portugal");

        Object[] keys = map.keySet().toArray();
        Object key = keys[new Random().nextInt(keys.length)];

        System.out.print(key + ", country = ");
        String in = scanner.nextLine();
        if (in.equals(map.get(key))) {
            return 1;
        }
        return 0;
    }
}
