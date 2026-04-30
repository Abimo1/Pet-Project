package Interface;

import util.ValidationService;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DataViaTheFile {
    public static void dataViaTheFile(Path fileName, BusCollection buses) {
        try(BufferedReader reader = Files.newBufferedReader(fileName)) {
            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty())
                    continue;

                String[] parts = line.split("[\\s+]");

                if (parts.length != 3) {
                    System.out.println(line + " - недостаточно данных");
                    continue;
                }

                try {
                    int number = ValidationService.validateNumber(parts[0]);
                    String model = ValidationService.validateModel(parts[1]);
                    int mileage = ValidationService.validateMileage(parts[2]);

                    Bus bus = Bus.BusBuilder.newInstance()
                            .setNumber(number)
                            .setModel(model)
                            .setMileage(mileage)
                            .build();

                    buses.add(bus);

                } catch (IllegalArgumentException e) {
                    System.out.println("Ошибка: " + e.getMessage());
                }


            }
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
