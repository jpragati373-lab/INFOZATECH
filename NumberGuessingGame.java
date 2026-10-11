import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 7;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int roundNumber = 1;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100.");
        System.out.println("You have 7 valid guesses per round.");

        while (true) {
            int secretNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n--- Round " + roundNumber + " ---");

            // Invalid entries and numbers outside the range do not use an attempt.
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (" + (attempts + 1) + "/"
                        + MAX_ATTEMPTS + "): ");

                if (!scanner.hasNextLine()) {
                    System.out.println("\nInput ended. Thanks for playing!");
                    System.out.println("Final score: " + score);
                    return;
                }

                String input = scanner.nextLine().trim();
                int guess;

                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException exception) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    continue;
                }

                if (guess < MIN_NUMBER || guess > MAX_NUMBER) {
                    System.out.println("Please enter a number from "
                            + MIN_NUMBER + " to " + MAX_NUMBER + ".");
                    continue;
                }

                attempts++;

                if (guess < secretNumber) {
                    System.out.println("Too low. Try a higher number.");
                } else if (guess > secretNumber) {
                    System.out.println("Too high. Try a lower number.");
                } else {
                    System.out.println("Congratulations! You guessed the number in "
                            + attempts + " valid attempt(s).");
                    guessedCorrectly = true;
                    score++;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("You used all " + MAX_ATTEMPTS
                        + " valid attempts. The correct number was " + secretNumber + ".");
            }

            System.out.println("Running score: " + score
                    + " point(s) (1 point for each round won).");
            roundNumber++;

            while (true) {
                System.out.print("Would you like to play another round? (y/n): ");

                if (!scanner.hasNextLine()) {
                    System.out.println("\nInput ended. Thanks for playing!");
                    System.out.println("Final score: " + score);
                    return;
                }

                String answer = scanner.nextLine().trim();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
                    break;
                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
                    System.out.println("Thanks for playing! Final score: " + score);
                    return;
                } else {
                    System.out.println("Please enter y or n.");
                }
            }
        }
    }
}
