package bullscows;

import utils.Validator;
import java.util.Scanner;

public class UserInterface {

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        printWelcomeText();
        System.out.print("Please, enter the secret code's length:\n> ");
        String textCodeLength = scanner.nextLine();
        if (textCodeLength.equalsIgnoreCase("quit")) {
            System.out.println("Exiting the game..");
            return;
        }
        int codeLength = validator.validateCodeLength(textCodeLength);
        if (codeLength == -1) {
            return;
        }

        System.out.print("Input the number of possible symbols in the code:\n> ");
        String textNumOfSymbols = scanner.nextLine();
        if (textNumOfSymbols.equalsIgnoreCase("quit")) {
            System.out.println("Exiting the game..");
            return;
        }
        int numOfSymbols = validator.validateNumOfSymbols(textNumOfSymbols, codeLength);
        if (numOfSymbols == -1) {
            return;
        }
        BullsAndCows bac = new BullsAndCows(codeLength, numOfSymbols, 36);
        String secretCode = bac.generateSecretCode();
        int bulls = bac.checkUserGuesses(secretCode);
        if (bulls == -1) {
            return;
        }
        if (bulls == secretCode.length()) {
            System.out.println("Congratulations! You guessed the secret code.");
        }
        scanner.close();
    }

    public void printResult(int bulls, int cows) {
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
}
