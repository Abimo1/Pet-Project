package bus;

public class SortByMileage implements SortStrategy { // Сортировка по пробегу

    @Override
    public void sort(Bus[] buses) {

        for (int i = 0; i < buses.length - 1; i++) { // Внешний цикл

            for (int j = 0; j < buses.length - i - 1; j++) { // Внутренний цикл

                if (buses[j].getMileage() > buses[j + 1].getMileage()) { // Сравнение пробега

                    Bus temp = buses[j]; // Сохранение текущего
                    buses[j] = buses[j + 1]; // Перестановка
                    buses[j + 1] = temp; // Завершение обмена
                }
            }
        }
    }
}
