package bus;

import java.util.Arrays;

public class SortByNumber implements SortStrategy { // Реализация сортировки по номеру
    @Override
    public void sort(Bus[] buses) { // Метод сортировки массива
        for (int i = 0; i < buses.length - 1; i++) { // Внешний цикл Bubble Sort
            for (int j = 0; j < buses.length - i - 1; j++) { // Внутренний цикл сравнения
                if (buses[j].getNumber().compareTo(buses[j + 1].getNumber()) > 0) { // Если текущий номер больше следующего
                    Bus temp = buses[j]; // Сохраняем текущий элемент
                    buses[j] = buses[j + 1]; // Меняем местами
                    buses[j + 1] = temp; // Завершаем обмен
                }
            }
        }
    }
}
