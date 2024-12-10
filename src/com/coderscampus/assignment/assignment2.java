package com.coderscampus.assignment;

import java.util.Random;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        int theRandomNumber = createARandomNumber();
        numberGuessingGame(theRandomNumber);
    }

    private static int createARandomNumber() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private static void numberGuessingGame(int theNumber) {
        int numberOfGuesses = 0;
        boolean userGuessedCorrectly = false;

        while(numberOfGuesses < 5) {
            int guessedNumber = askForANumber();
            numberOfGuesses++;
            if (guessedNumber == theNumber) {
                userGuessedCorrectly = true;
                System.out.println("You win!");
                break;
            } else if (guessedNumber > theNumber) {
                System.out.println("Please pick a lower number");
            } else {
                System.out.println("Please pick a higher number.");
            }
        }
        if (!userGuessedCorrectly) {
            System.out.println("You lose!\n" +
                    "The number to guess was: " + theNumber + ".");
        }
    }

    private static int askForANumber() {
        Scanner input = new Scanner(System.in);
        int theNumber;
        boolean numberInRange = false;
        do {
            System.out.print("Pick a number between 1 and 100: ");
            theNumber = input.nextInt();
            if ((theNumber >= 1)&&(theNumber <= 100)) numberInRange = true;
            else System.out.println("Your guess is not between 1 and 100, please try again.");
        } while(!numberInRange);
        return theNumber;
    }

}