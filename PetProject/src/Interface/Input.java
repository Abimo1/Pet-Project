package Interface;

import util.ValidationService;

import java.util.Scanner;

public class Input {
    public static int validateInputNumber(Scanner scanner) {

        int value;
        String input = null;
        while(true) {
            System.out.print("Введите номер автобуса: ");
            input = scanner.nextLine().trim();
            if (input == null || input.isEmpty()) {
                System.out.println("Введены некорректные данные!");
                continue;
            }

            try {
                value = ValidationService.validateNumber(input);
                System.out.println(value);
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
            input = scanner.nextLine().trim();
            if (input == null || input.isEmpty()) {
                System.out.println("Введены некорректные данные!");
                continue;
            }

            try {
                value = ValidationService.validateModel(input);
                System.out.println(value);
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
            input = scanner.nextLine().trim();
            if (input == null || input.isEmpty()) {
                System.out.println("Введены некорректные данные!");
                continue;
            }

            try {
                value = ValidationService.validateMileage(input);
                System.out.println(value);
                return value;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
