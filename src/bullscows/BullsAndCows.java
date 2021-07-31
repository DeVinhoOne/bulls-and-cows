package bullscows;

import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {

    public int checkUserGuesses(String secretCode) {
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface();
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
            bulls = this.countBulls(secretCode, input);
            cows = this.countCows(secretCode, input);
            ui.printResult(bulls, cows);
            turn++;
        }
        return bulls;
    }

    public String generateSecretCode(int codeLength, int numOfSymbols) {
        StringBuilder res = new StringBuilder();
        Random random = new Random();
        if (codeLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + codeLength +
                    " because there aren't enough unique characters.");
            return "";
        }
        char[] symbols = generateSymbols(numOfSymbols);

        while (res.length() != codeLength) {
            int randomNumber = random.nextInt(numOfSymbols);
            char currChar = symbols[randomNumber];
            if (res.toString().contains(String.valueOf(currChar))) {
                continue;
            }
            res.append(currChar);
        }
        printPreparedCode(res.toString(), symbols);
        return res.toString();
    }

    private int countBulls(String code, String input) {
        int bulls = 0;
        char[] codeArr = code.toCharArray();
        for (int i = 0; i < input.length(); i++) {
            char currDigit = input.charAt(i);
            if (currDigit == codeArr[i]) {
                bulls++;
            }
        }
        return bulls;
    }

    private int countCows(String code, String input) {
        int cows = 0;
        for (int i = 0; i < input.length(); i++) {
            char inputDigit = input.charAt(i);
            int idx = code.indexOf(inputDigit);
            if (idx == -1) {
                continue;
            }
            if (idx != i && code.contains(String.valueOf(inputDigit))) {
                cows++;
            }
        }
        return cows;
    }

    private char[] generateSymbols(int numOfSymbols) {
        char[] allSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
                'v', 'w', 'x', 'y', 'z'};
        char[] slice = new char[numOfSymbols];
        System.arraycopy(allSymbols, 0, slice, 0, slice.length);
        return slice;
    }

    private void printPreparedCode(String secretCode, char[] symbols) {
        String firstNum = "";
        String lastNum = "";
        String firstLetter = "";
        String lastLetter = "";
        for (int i = 0; i < symbols.length; i++) {
            char currChar = symbols[i];
            if (i == 0 && Character.isDigit(currChar)) {
                firstNum = String.valueOf(currChar);
            } else if (Character.isDigit(currChar)) {
                lastNum = String.valueOf(currChar);
            } else if (i == 10 && Character.isAlphabetic(currChar)) {
                firstLetter = String.valueOf(currChar);
            } else if (Character.isAlphabetic(currChar)) {
                lastLetter = String.valueOf(currChar);
            }
        }
        //generate stars
        StringBuilder stars = new StringBuilder("*".repeat(secretCode.length()));
        //print
        if (symbols.length <= 10) {
            System.out.println("The secret is prepared: "+stars+" ("+firstNum+"-"+lastNum+").");
        } else {
            System.out.println("The secret is prepared: "+stars+" ("+firstNum+"-"+lastNum+", "+firstLetter+"-"+lastLetter+").");
        }
    }
}
