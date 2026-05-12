package main.java.bus;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class BusSortingApp {
    private Scanner scanner;
    private SortStrategy sortStrategy;
    private DataValidator validator;

    public BusSortingApp() {
        this.scanner = new Scanner(System.in);
        this.validator = new DataValidator();
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        while (scanner.hasNextInt()) {
            System.out.println("Выберите способ заполнения массива автобусов:");
            System.out.println("1. Ввод вручную");
            System.out.println("2. Заполнение случайными данными");
            System.out.println("3. Загрузка из файла");
            System.out.println("4. Stream заполнение");
            System.out.println("5. Подсчёт вхождений (многопоточно)");
            System.out.println("0. Выход");

            int choice;

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число.");
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                break;
            }

            Bus[] buses = null;
            switch (choice) {
                case 1:
                    buses = manualInput();
                    break;
                case 2:
                    buses = randomInput(); // Вызов метода randomInput
                    break;
                case 3:
                    buses = fileInput();
                    break;
                case 4:
                    sortStrategy = new SortByMileageEvenOnly();
                    break;
                case 5:
                    buses = streamInput();
                    break;
                case 6:
                    runThreadCounter(buses);
                    continue;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    continue;
            }

            System.out.println("Выберите стратегию сортировки:");
            System.out.println("1. По номеру");
            System.out.println("2. По модели");
            System.out.println("3.ч По пробегу");
            System.out.println("4. По пробегу (чётные сортируются)");

            int sortChoice;

            try {
                sortChoice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число.");
                scanner.nextLine();
                continue;
            }

            switch (sortChoice) {
                case 1:
                    sortStrategy = new SortByNumber();
                    break;
                case 2:
                    sortStrategy = new SortByModel();
                    break;
                case 3:
                    sortStrategy = new SortByMileage();
                    break;
                default:
                    System.out.println("Неверный выбор, сортировка не выполнена.");
                    continue;
            }

            sortStrategy.sort(buses);

            System.out.println("Отсортированные автобусы:");
            for (Bus bus : buses) {
                System.out.println(bus);
            }

// ДОБАВЛЯЕМ ЗАПИСЬ В ФАЙЛ
            FileWriterUtil.writeBuses(buses);
        }
    }

    private Bus[] manualInput() {
        System.out.print("Введите количество автобусов: ");

        int count;

        try {
            count = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число.");
            scanner.nextLine();
            return new Bus[0];
        }

        Bus[] buses = new Bus[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Введите номер автобуса: ");
            String number = scanner.next();
            System.out.print("Введите модель автобуса: ");
            String model = scanner.next();
            System.out.print("Введите пробег автобуса: ");
            int mileage = scanner.nextInt();

            if (!validator.validateBusData(number, model, mileage)) {
                System.out.println("Некорректные данные, попробуйте снова.");
                i--; // Повторить ввод для текущего автобуса
                continue;
            }

            buses[i] = new Bus.Builder().setNumber(number).setModel(model).setMileage(mileage).build();
        }
        return buses;
    }

    private Bus[] randomInput() {
        System.out.print("Введите количество автобусов для случайного заполнения: ");

        int count;

        try {
            count = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Введите число.");
            scanner.nextLine();
            return new Bus[0];
        }

        Bus[] buses = new Bus[count];

        for (int i = 0; i < count; i++) {
            String number = "Number" + (i + 1);
            String model = "Model" + (i + 1);
            int mileage = (int) (Math.random() * 100000); // Случайный пробег
            buses[i] = new Bus.Builder().setNumber(number).setModel(model).setMileage(mileage).build();
        }
        return buses;
    }
    private Bus[] fileInput() {
        List<Bus> busList = new ArrayList<>();

        try {
            File file = new File("buses.txt");
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length != 3) {
                    continue;
                }

                String number = parts[0];
                String model = parts[1];
                int mileage = Integer.parseInt(parts[2]);

                if (validator.validateBusData(number, model, mileage)) {
                    Bus bus = new Bus.Builder()
                            .setNumber(number)
                            .setModel(model)
                            .setMileage(mileage)
                            .build();

                    busList.add(bus);
                }
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла.");
        }

        return busList.toArray(new Bus[0]);
    }

    private Bus[] streamInput() {
        System.out.print("Введите количество автобусов: ");
        int count = scanner.nextInt();

        BusCollection collection = new BusCollection(count);

        IntStream.range(0, count)
                .mapToObj(i -> new Bus.Builder()
                        .setNumber("Number" + (i + 1))
                        .setModel("Model" + (i + 1))
                        .setMileage((int) (Math.random() * 100000))
                        .build())
                .forEach(collection::add);

        return collection.toArray();
    }

    private void runThreadCounter(Bus[] buses) {
        System.out.print("Введите mileage для поиска: ");
        int n = scanner.nextInt();

        BusCounterThread thread = new BusCounterThread(buses, n);

        thread.start();

        try {
            thread.join(); // ждём завершения потока
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        System.out.println("Количество совпадений: " + thread.getResult());
    }

    public static void main(String[] args) {
        BusSortingApp app = new BusSortingApp();
        app.start();
    }
}

