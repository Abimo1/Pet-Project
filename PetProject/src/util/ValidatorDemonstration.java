package util;

import util.ValidationService;
import java.util.Scanner;

public class ValidatorDemonstration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n--- VALIDATOR TEST ---");
            System.out.println("1. Test Number");
            System.out.println("2. Test Model");
            System.out.println("3. Test Mileage");
            System.out.println("0. Exit");

            String choice = sc.next();

            try {

                switch (choice) {

                    case "1" -> {
                        System.out.print("Enter number: ");
                        String number = sc.next();
                        System.out.println("OK: " + util.ValidationService.validateNumber(number));
                    }

                    case "2" -> {
                        System.out.print("Enter model: ");
                        String model = sc.next();
                        System.out.println("OK: " + ValidationService.validateModel(model));
                    }

                    case "3" -> {
                        System.out.print("Enter mileage: ");
                        String  mileage = sc.next();
                        System.out.println("OK: " + ValidationService.validateMileage(mileage));
                    }

                    case "0" -> {
                        System.out.println("Exit...");
                        return;
                    }

                    default -> System.out.println("Wrong option");
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}