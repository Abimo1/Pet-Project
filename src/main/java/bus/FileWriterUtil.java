package bus;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterUtil {

    private static final String FILE_NAME = "sorted_buses.txt"; // Имя файла

    // запись массива автобусов в файл (append режим)
    public static void writeBuses(Bus[] buses) { // Метод записи массива

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) { // Открываем файл в режиме добавления

            writer.write("=== NEW SORT RESULT ===\n"); // Заголовок записи

            for (Bus bus : buses) { // Проходим по массиву
                writer.write(bus.toString() + "\n"); // Записываем автобус
            }

            writer.write("\n"); // Пустая строка

        } catch (IOException e) { // Ошибка записи
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
