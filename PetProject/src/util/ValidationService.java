package util;

public class ValidationService {
    public static int validateNumber(String input) {
        int value;

        try {
            value = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Number must be a number");
        }

        if (value <= 0) {
            throw new IllegalArgumentException("Power must be > 0");
        }

        return value;
    }

    public static String validateModel(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("Model is empty");
        }
        return input;
    }

    public static int validateMileage(String input) {
        int value;

        try {
            value = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("Year must be a number");
        }

        if (value < 1900 || value > 2026) {
            throw new IllegalArgumentException("Year is wrong");
        }

        return value;
    }
}

