package williamnelson.personal.src;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner; // For user input

public class Main {

    public static void main(String[] args) {
    	// TODO have args quick-select the mode

        Scanner scanner = new Scanner(System.in); // Create user input scanner

        System.out.println("Welcome to Geography Guesser!");

        boolean badMode; // set if an invalid mode is selected
        do  { // Used as a goto statement, so whenever a bad mode is inputted, goes here.

            System.out.println("TODO add more games");
            System.out.println("Please select one of the following modes: ");
            System.out.println(" - 1: Identify country from city name");
            // TODO add more games
            System.out.println();
            System.out.print("Selection: ");
            String modeSelection = scanner.next().trim(); // Read user selection, cut off excess whitespace

            // Parse user-selected mode
            switch (modeSelection) {
                case "1" -> {
                    badMode = false;
                    countryCity();
                }

                default -> { // If mode is invalid
                    clearScreen(); // Clears screen
                    System.out.println(MessageFormat.format("Sorry, but ''{0}'' is not a valid mode. Please try again.", modeSelection));
                    badMode = true; // Setting to restart mode selection
                }
            }
        } while (badMode); // Continues to loop if an invalid mode was selected

    }

    // Helper functions for whole application after this comment
    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clears screen
        System.out.flush(); // Moves cursor to top left of screen
    }

    public static void countryCity() {
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
            countryCity(); // Restarts this function
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

