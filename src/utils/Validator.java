package utils;

public class Validator {

    public boolean ValidateNumberInput(String textNumber) {
        try {
            int number = Integer.parseInt(textNumber);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
