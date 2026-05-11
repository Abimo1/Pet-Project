package tests;

import bus.BusSortingApp;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BusSortingAppTest {

    @Test
    public void testManualInput() {

        Scanner scanner = new Scanner(
                "1\n" +
                        "1\n" +
                        "A123BC\n" +
                        "Mercedes\n" +
                        "10000\n" +
                        "1\n" +   // сортировка
                        "0\n"
        );

        BusSortingApp app = new BusSortingApp();
        app.setScanner(scanner);

        assertDoesNotThrow(app::start);
    }

    @Test
    public void testRandomInput() {

        Scanner scanner = new Scanner(
                "2\n" +
                        "5\n" +
                        "1\n" +  // сортировка
                        "0\n"
        );

        BusSortingApp app = new BusSortingApp();
        app.setScanner(scanner);

        assertDoesNotThrow(app::start);
    }
}
//package tests;
//
//import bus.BusSortingApp;
//import org.junit.jupiter.api.Test;
//
//import java.util.Scanner;
//
//public class BusSortingAppTest {
//
//    @Test
//    public void testManualInput() {
//
//        Scanner scanner = new Scanner(
//                "1\n" +   // выбор: ручной ввод
//                        "1\n" +   // количество автобусов
//                        "A123BC\n" +
//                        "Mercedes\n" +
//                        "10000\n" +
//                        "0\n"     // выход
//        );
//
//        BusSortingApp app = new BusSortingApp();
//        app.setScanner(scanner);
//
//        app.start();
//    }
//
//    @Test
//    public void testRandomInput() {
//
//        Scanner scanner = new Scanner(
//                "2\n" +   // выбор: случайные данные
//                        "5\n" +   // количество автобусов
//                        "0\n"     // выход
//        );
//
//        BusSortingApp app = new BusSortingApp();
//        app.setScanner(scanner);
//
//        app.start();
//    }
//}
//package Tests;
//
//import Bus.BusSortingApp;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.mockito.Mockito.*;
//
//public class BusSortingAppTest {
//
//    @Test
//    public void testManualInput() {
//        Scanner scanner = Mockito.mock(Scanner.class);
//        when(scanner.nextInt()).thenReturn(1, 1, 2, 10000, 0); // Ввод 1 автобуса
//        BusSortingApp app = new BusSortingApp();
//        app.setScanner(scanner); // Устанавливаем наш мок-сканер
//
//        app.start();
//
//        // Здесь можно проверить, что автобусы были созданы корректно
//    }
//
//    @Test
//    public void testRandomInput() {
//        Scanner scanner = Mockito.mock(Scanner.class);
//        when(scanner.nextInt()).thenReturn(1, 2, 5, 0); // Ввод 5 автобусов
//        BusSortingApp app = new BusSortingApp();
//        app.setScanner(scanner); // Устанавливаем наш мок-сканер
//
//        app.start();
//
//        // Здесь можно проверить, что автобусы были сгенерированы корректно
//    }
//}