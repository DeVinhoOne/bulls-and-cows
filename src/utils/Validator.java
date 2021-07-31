package utils;

public class Validator {

    public int validateCodeLength(String textCodeLength) {
        int codeLength;
        if (this.validateNumberInput(textCodeLength)) {
            codeLength = Integer.parseInt(textCodeLength);
        } else {
            System.out.println("Error: \""+textCodeLength+"\" isn't a valid number.");
            return -1;
        }
        if (codeLength <= 0) {
            System.out.println("Error: code length cannot be zero or less.");
            return -1;
        }
        return codeLength;
    }

    public int validateNumOfSymbols(String textNumOfSymbols, int codeLength) {
        int numOfSymbols;
        if (this.validateNumberInput(textNumOfSymbols)) {
            numOfSymbols = Integer.parseInt(textNumOfSymbols);
        } else {
            System.out.println("Error: \""+textNumOfSymbols+"\" isn't a valid number.");
            return -1;
        }
        if (numOfSymbols > 36) {
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return -1;
        } else if (numOfSymbols < codeLength) {
            System.out.println("Error: it's not possible to generate a code with a length of "+codeLength+" with "+numOfSymbols+" unique symbols.");
            return -1;
        }
        return numOfSymbols;
    }

    private boolean validateNumberInput(String textNumber) {
        try {
            Integer.parseInt(textNumber);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
