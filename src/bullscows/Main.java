package bullscows;

public class Main {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.startGame();
    }

//    public static void startGame() {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.print("Please, enter the secret code's length:\n> ");
//        String textCodeLength = scanner.nextLine();
//        int codeLength;
//        try {
//            codeLength = Integer.parseInt(textCodeLength);
//        } catch (NumberFormatException e) {
//            System.out.println("Error: \""+textCodeLength+"\" isn't a valid number.");
//            return;
//        }
//        if (codeLength <= 0) {
//            System.out.println("Error: code length cannot be zero or less.");
//            return;
//        }
//        System.out.print("Input the number of possible symbols in the code:\n> ");
//        int numOfSymbols = scanner.nextInt();
//        if (numOfSymbols > 36) {
//            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
//            return;
//        } else if (numOfSymbols < codeLength) {
//            System.out.println("Error: it's not possible to generate a code with a length of "+codeLength+" with "+numOfSymbols+" unique symbols.");
//            return;
//        }
//        String secretCode = generateSecretCode(codeLength, numOfSymbols);
//        if (secretCode.isEmpty()) {
//            return;
//        }
//        int bulls = 0;
//        int cows;
//        int turn = 1;
//        System.out.println("Okay, let's start a game!");
//        while (bulls != secretCode.length()) {
//            System.out.println("Turn " + turn + ":");
//            System.out.print("> ");
//            String input = scanner.nextLine();
//            bulls = countBulls(secretCode, input);
//            cows = countCows(secretCode, input);
//            printResult(bulls, cows);
//            turn++;
//        }
//        if (bulls == secretCode.length()) {
//            System.out.println("Congratulations! You guessed the secret code.");
//        }
//        scanner.close();
//    }
//
//    public static void printResult(int bulls, int cows) {
//        if (bulls == 0 && cows == 0) {
//            System.out.println("Grade: None.");
//        } else if (bulls > 0 && cows > 0) {
//            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s).");
//        } else if (cows > 0) {
//            System.out.println("Grade: " + cows + " cow(s).");
//        } else if (bulls > 0) {
//            System.out.println("Grade: " + bulls + " bull(s).");
//        }
//    }
//
//    public static int countBulls(String code, String input) {
//        int bulls = 0;
//        char[] codeArr = code.toCharArray();
//        for (int i = 0; i < input.length(); i++) {
//            char currDigit = input.charAt(i);
//            if (currDigit == codeArr[i]) {
//                bulls++;
//            }
//        }
//        return bulls;
//    }
//
//    public static int countCows(String code, String input) {
//        int cows = 0;
//        for (int i = 0; i < input.length(); i++) {
//            char inputDigit = input.charAt(i);
//            int idx = code.indexOf(inputDigit);
//            if (idx == -1) {
//                continue;
//            }
//            if (idx != i && code.contains(String.valueOf(inputDigit))) {
//                cows++;
//            }
//        }
//        return cows;
//    }
//
//    public static String generateSecretCode(int codeLength, int numOfSymbols) {
//        StringBuilder res = new StringBuilder();
//        Random random = new Random();
//        if (codeLength > 36) {
//            System.out.println("Error: can't generate a secret number with a length of " + codeLength +
//                    " because there aren't enough unique characters.");
//            return "";
//        }
//        char[] symbols = generateSymbols(numOfSymbols);
//
//        while (res.length() != codeLength) {
//            int randomNumber = random.nextInt(numOfSymbols);
//            char currChar = symbols[randomNumber];
//            if (res.toString().contains(String.valueOf(currChar))) {
//                continue;
//            }
//            res.append(currChar);
//        }
//        printPreparedCode(res.toString(), symbols);
//        return res.toString();
//    }
//
//    public static char[] generateSymbols(int numOfSymbols) {
//        //we assume that numOfSymbols can't be less than 10 and greater than 36 (length of allSymbols array)
//        char[] allSymbols = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
//                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
//                'v', 'w', 'x', 'y', 'z'};
//        char[] slice = new char[numOfSymbols];
//        for (int i = 0; i < slice.length; i++) {
//            slice[i] = allSymbols[i];
//        }
//        return slice;
//    }
//
//    public static void printPreparedCode(String secretCode, char[] symbols) {
//        String firstNum = "";
//        String lastNum = "";
//        String firstLetter = "";
//        String lastLetter = "";
//        for (int i = 0; i < symbols.length; i++) {
//            char currChar = symbols[i];
//            if (i == 0 && Character.isDigit(currChar)) {
//                firstNum = String.valueOf(currChar);
//            } else if (Character.isDigit(currChar)) {
//                lastNum = String.valueOf(currChar);
//            } else if (i == 10 && Character.isAlphabetic(currChar)) {
//                firstLetter = String.valueOf(currChar);
//            } else if (Character.isAlphabetic(currChar)) {
//                lastLetter = String.valueOf(currChar);
//            }
//        }
//        //generate stars
//        StringBuilder stars = new StringBuilder();
//        for (int i = 0; i < secretCode.length(); i++) {
//            stars.append("*");
//        }
//        //print
//        if (symbols.length <= 10) {
//            System.out.println("The secret is prepared: "+stars+" ("+firstNum+"-"+lastNum+").");
//        } else {
//            System.out.println("The secret is prepared: "+stars+" ("+firstNum+"-"+lastNum+", "+firstLetter+"-"+lastLetter+").");
//        }
//    }
}
