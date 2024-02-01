package code;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int difficultyLevel = 0;
        int score = 0;

        while (true) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("Choose a difficulty level (1: easy, 2: medium, 3: hard):");
            difficultyLevel = scanner.nextInt();

            if (difficultyLevel < 1 || difficultyLevel > 3) {
                System.out.println("Invalid difficulty level. Please try again.");
                continue;
            }

            int numberToGuess = random.nextInt(100 - (difficultyLevel * 20)) + 1;
            int attemptsLimit = 10 - difficultyLevel;
            int numRounds = 1;

            for (int i = 0; i < numRounds; i++) {
                int attempts = 0;
                System.out.printf("New round! I'm thinking of a number between 1 and %d.%n", 100 - (difficultyLevel * 20));
                while (attempts < attemptsLimit) {
                    System.out.printf("Enter your guess (attempts left: %d): ", attemptsLimit - attempts);
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess < numberToGuess) {
                        System.out.println("Too low!");
                    } else if (guess > numberToGuess) {
                        System.out.println("Too high!");
                    } else {
                        System.out.printf("Congratulations! You guessed the number (%d) in %d attempts!%n", numberToGuess, attempts);
                        score++;
                        break;
                    }
                }

                if (attempts == attemptsLimit) {
                    System.out.printf("You didn't guess the number in %d attempts. The correct number was %d.%n", attemptsLimit, numberToGuess);
                }
            }

            System.out.printf("Your score: %d/%d%n", score, numRounds);
            System.out.println("Thanks for playing! Goodbye.");
            break;
        }

        scanner.close();
    }
}
