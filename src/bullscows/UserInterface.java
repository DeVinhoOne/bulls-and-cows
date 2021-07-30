package bullscows;

import utils.Validator;

import java.util.Scanner;

public class UserInterface {

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        BullsAndCows bac = new BullsAndCows();
        Validator validator = new Validator();
        printWelcomeText();
        System.out.print("Please, enter the secret code's length:\n> ");
        String textCodeLength = scanner.nextLine();
        if (textCodeLength.equalsIgnoreCase("quit")) {
            System.out.println("Exiting the game..");
            return;
        }
        int codeLength;
        if (validator.ValidateNumberInput(textCodeLength)) {
            codeLength = Integer.parseInt(textCodeLength);
        } else {
            System.out.println("Error: \""+textCodeLength+"\" isn't a valid number.");
            return;
        }
        if (codeLength <= 0) {
            System.out.println("Error: code length cannot be zero or less.");
            return;
        }

        System.out.print("Input the number of possible symbols in the code:\n> ");
        String textNumOfSymbols = scanner.nextLine();
        if (textNumOfSymbols.equalsIgnoreCase("quit")) {
            System.out.println("Exiting the game..");
            return;
        }
        int numOfSymbols;
        if (validator.ValidateNumberInput(textNumOfSymbols)) {
            numOfSymbols = Integer.parseInt(textNumOfSymbols);
        } else {
            System.out.println("Error: \""+textNumOfSymbols+"\" isn't a valid number.");
            return;
        }
        if (numOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        } else if (numOfSymbols < codeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of "+codeLength+" with "+numOfSymbols+" unique symbols.");
            return;
        }

        String secretCode = bac.generateSecretCode(codeLength, numOfSymbols);
        int bulls = checkUserGuesses(secretCode);
        if (bulls == -1) {
            return;
        }
        if (bulls == secretCode.length()) {
            System.out.println("Congratulations! You guessed the secret code.");
        }
        scanner.close();
    }

    private void printResult(int bulls, int cows) {
        if (bulls == 0 && cows == 0) {
            System.out.println("Grade: None.");
        } else if (bulls > 0 && cows > 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
        } else if (cows > 0) {
            System.out.println("Grade: " + cows + " cow(s).");
        } else if (bulls > 0) {
            System.out.println("Grade: " + bulls + " bull(s).");
        }
    }

    private void printWelcomeText() {
        System.out.println("Bulls And Cows - The Game\nYour task is to guess the secret code.\nType quit at any time to exit the game.\nGood luck.\n");
    }

    private int checkUserGuesses(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        BullsAndCows bac = new BullsAndCows();
        int bulls = 0;
        int cows;
        int turn = 1;
        System.out.println("Okay, let's start a game!");
        while (bulls != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            System.out.print("> ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the game..");
                return -1;
            }
            bulls = bac.countBulls(secretCode, input);
            cows = bac.countCows(secretCode, input);
            printResult(bulls, cows);
            turn++;
        }
        return bulls;
    }
}
