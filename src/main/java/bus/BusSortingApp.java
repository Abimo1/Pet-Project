package bus;

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

        this.scanner = scanner; // Замена стандартного ввода
    }

    public void start() { // Основной цикл программы
        while (true) {
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
                    buses = randomInput();
                    break;
                case 3:
                    buses = fileInput();
                    break;
                case 4:
                    buses = streamInput();
                    break;
                case 5:
                    buses = manualInput(); // или другой источник
                    runThreadCounter(buses);
                    continue;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
                    continue;
            }

            System.out.println("Выберите стратегию сортировки:");
            System.out.println("1. По номеру");
            System.out.println("2. По модели");
            System.out.println("3. По пробегу");
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
                case 4:
                    sortStrategy = new SortByMileageEvenOnly();
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

        for (int i = 0; i < count; i++) { // Цикл для ввода данных о автобусах
            System.out.print("Введите номер автобуса: "); // Запрос номера автобуса
            String number = scanner.next();
            System.out.print("Введите модель автобуса: "); // Запрос модели автобуса
            String model = scanner.next();
            System.out.print("Введите пробег автобуса: "); // Запрос пробега автобуса
            int mileage = scanner.nextInt();

            // Проверка корректности введенных данных
            if (!validator.validateBusData(number, model, mileage)) {
                System.out.println("Некорректные данные, попробуйте снова.");
                i--; // Повторить ввод для текущего автобуса
                continue; // Переход к следующей итерации цикла
            }

            // Создание объекта Bus с введенными данными
            buses[i] = new Bus.Builder().setNumber(number).setModel(model).setMileage(mileage).build();
        }
        return buses;
    }

    private Bus[] randomInput() {
        System.out.print("Введите количество автобусов для случайного заполнения: ");

        int count; // Переменная для хранения количества автобусов

        // Обработка исключения для неверного ввода
        try {
            count = scanner.nextInt(); // Считывание количества автобусов
        } catch (InputMismatchException e) {
            System.out.println("Введите число."); // Сообщение об ошибке
            scanner.nextLine(); // Очистка буфера
            return new Bus[0]; // Возврат пустого массива
        }

        Bus[] buses = new Bus[count]; // Создание массива для автобусов

        for (int i = 0; i < count; i++) { // Цикл для генерации автобусов
            String number = "Number" + (i + 1); // Генерация номера автобуса
            String model = "Model" + (i + 1); // Генерация модели автобуса
            int mileage = (int) (Math.random() * 100000); // Случайный пробег
            // Создание объекта Bus с случайными данными
            buses[i] = new Bus.Builder().setNumber(number).setModel(model).setMileage(mileage).build();
        }
        return buses;
    }
    private Bus[] fileInput() {
        List<Bus> busList = new ArrayList<>(); // Список для хранения автобусов

        try {
            File file = new File("buses.txt"); // Создание объекта File для чтения из файла
            Scanner fileScanner = new Scanner(file); // Сканер для чтения из файла

            // Чтение файла построчно
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine(); // Чтение строки
                String[] parts = line.split(","); // Разделение строки на части

                // Проверка, что строка содержит 3 элемента
                if (parts.length != 3) {
                    continue; // Пропустить некорректные строки
                }

                String number = parts[0]; // Считывание номера автобуса
                String model = parts[1]; // Считывание модели автобуса
                int mileage = Integer.parseInt(parts[2]); // Считывание пробега автобуса

                // Проверка корректности данных
                if (validator.validateBusData(number, model, mileage)) {
                    // Создание объекта Bus и добавление в список
                    Bus bus = new Bus.Builder()
                            .setNumber(number)
                            .setModel(model)
                            .setMileage(mileage)
                            .build();

                    busList.add(bus); // Добавление автобуса в список
                }
            }

            fileScanner.close(); // Закрытие сканера

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла.");
        }

        return busList.toArray(new Bus[0]); // Возврат массива автобусов
    }

    private Bus[] streamInput() {
        System.out.print("Введите количество автобусов: ");
        int count = scanner.nextInt(); // Считывание количества автобусов

        BusCollection collection = new BusCollection(count); // Создание коллекции автобусов

        // Генерация автобусов с использованием Stream API
        IntStream.range(0, count)
                .mapToObj(i -> new Bus.Builder()
                        .setNumber("Number" + (i + 1)) // Генерация номера автобуса
                        .setModel("Model" + (i + 1)) // Генерация модели автобуса
                        .setMileage((int) (Math.random() * 100000)) // Генерация случайного пробега
                        .build())
                .forEach(collection::add); // Добавление автобусов в коллекцию

        return collection.toArray();
    }

    private void runThreadCounter(Bus[] buses) {
        System.out.println("Введите mileage для поиска: ");
        int n = scanner.nextInt(); // Считывание пробега для поиска

        BusCounterThread thread = new BusCounterThread(buses, n); // Создание потока для подсчета

        thread.start(); // Запуск потока

        try {
            thread.join(); // ждём завершения потока
        } catch (InterruptedException e) {
            System.out.println("Поток был прерван");
        }

        System.out.println("Количество совпадений: " + thread.getResult());
    }

    public static void main(String[] args) {
        BusSortingApp app = new BusSortingApp(); // Создание экземпляра приложения
        app.start(); // Запуск приложения
    }
}

