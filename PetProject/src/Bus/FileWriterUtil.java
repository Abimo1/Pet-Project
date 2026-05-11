package main.java.bus;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    private static final String FILE_NAME = "sorted_buses.txt";

    // запись массива автобусов в файл (append режим)
    public static void writeBuses(Bus[] buses) {

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {

            writer.write("=== NEW SORT RESULT ===\n");

            for (Bus bus : buses) {
                writer.write(bus.toString() + "\n");
            }

            writer.write("\n");

        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
