package Interface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileName {
    public static Path inputFileName() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path file;
        System.out.print("Введите имя файла: ");
        do {
            String fileName = scanner.nextLine();
            file = Paths.get(fileName);
            if (!Files.exists(file)) {
                System.out.print("Такого файла не существует: ");
            }
        } while (!Files.exists(file));
        return file;
    }
}
