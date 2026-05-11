package bus;

public class BusCounterThread extends Thread { // Поток подсчёта автобусов

    private final Bus[] buses; // Массив автобусов
    private final int targetMileage; // Искомый пробег

    private int result = 0; // Результат подсчёта

    public BusCounterThread(Bus[] buses, int targetMileage) {
        this.buses = buses; // Сохраняем массив
        this.targetMileage = targetMileage; // Сохраняем целевое значение
    }

    @Override
    public void run() { // Код потока
        for (Bus bus : buses) { // Проходим по массиву
            if (bus.getMileage() == targetMileage) { // Если пробег совпадает
                result++; // Увеличиваем счётчик
            }
        }
    }

    public int getResult() { // Получение результата
        return result;
    }
}