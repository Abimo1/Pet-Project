package Interface;

import util.ValidationService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class RandomDate {
    public static void randomDate(BusCollection buses) {
        Random random = new Random();
        int numberOfBuses = 0;
        String[] parts;
        String input = null;
        Scanner scanner = new Scanner(System.in);

        for (;;) {
            System.out.print("Введите количество автобусов, которые хотите сгенерировать: ");

            input = Input.stringNotEmpty(input, scanner);
            if (input.equals("-1")) continue;

            try {
                numberOfBuses = ValidationService.validateNumber(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }

        String line = "";

        Path file = Paths.get("BusNames.txt");
        try {
            line = Files.readString(file).trim();

        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        parts = line.replace(",", "").split("[\\s]");

        while (numberOfBuses != 0) {
            int number = random.nextInt(1001);
            String model = parts[random.nextInt(parts.length)];
            int mileage = random.nextInt(1000001);

            Bus bus = Bus.BusBuilder
                    .newInstance()
                    .setNumber(number)
                    .setModel(model)
                    .setMileage(mileage)
                    .build();

            buses.add(bus);

            numberOfBuses--;
        }
    }
}
