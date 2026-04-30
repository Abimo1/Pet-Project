package Interface;

import util.ValidationService;

import java.util.Scanner;

public class Input {
    public static int validateInputNumber(Scanner scanner) {

        int value;
        String input = null;
        while(true) {
            System.out.print("Введите номер автобуса: ");

            input = stringNotEmpty(input, scanner);
            if (input.equals("-1")) continue;

            if (input.equals("!exit")) return -1;

            try {
                value = ValidationService.validateNumber(input);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String validateInputModel(Scanner scanner) {

        String value;
        String input = null;
        while(true) {
            System.out.print("Введите модель автобуса: ");

            input = stringNotEmpty(input, scanner);
            if (input.equals("-1")) continue;

            if (input.equals("!exit")) return "!exit";

            try {
                value = ValidationService.validateModel(input);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static int validateInputMileage(Scanner scanner) {

        int value;
        String input = null;
        while(true) {
            System.out.print("Введите пробег автобуса: ");


            input = stringNotEmpty(input, scanner);
            if (input.equals("-1")) continue;

            if (input.equals("!exit")) return -1;

            try {
                value = ValidationService.validateMileage(input);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }

    public static String stringNotEmpty(String input, Scanner scanner) {
        input = scanner.nextLine().trim();
        if (input == null || input.isEmpty()) {
            return "-1";
        } else
            return input;
    }
}
