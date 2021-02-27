package williamnelson.personal.src;

import java.text.MessageFormat;
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
                    CountryByCity.main();
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
}
