package utils;

public class Validator {

    public boolean ValidateNumberInput(String textNumber) {
        try {
            Integer.parseInt(textNumber);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
