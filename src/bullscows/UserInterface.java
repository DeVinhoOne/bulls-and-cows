package bullscows;

import utils.Validator;

import java.util.Scanner;

public class UserInterface {

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        BullsAndCows bac = new BullsAndCows();
        Validator validator = new Validator();

        System.out.print("Please, enter the secret code's length:\n> ");
        String textCodeLength = scanner.nextLine();
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
        int bulls = 0;
        int cows;
        int turn = 1;
        System.out.println("Okay, let's start a game!");
        while (bulls != secretCode.length()) {
            System.out.println("Turn " + turn + ":");
            System.out.print("> ");
            String input = scanner.nextLine();
            bulls = bac.countBulls(secretCode, input);
            cows = bac.countCows(secretCode, input);
            printResult(bulls, cows);
            turn++;
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
}
