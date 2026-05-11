package bus;

public class SortByModel implements SortStrategy { // Сортировка по модели

    @Override
    public void sort(Bus[] buses) {

        for (int i = 0; i < buses.length - 1; i++) { // Внешний цикл

            for (int j = 0; j < buses.length - i - 1; j++) { // Внутренний цикл

                if (buses[j].getModel().compareTo(buses[j + 1].getModel()) > 0) { // Сравнение моделей

                    Bus temp = buses[j]; // Сохранение
                    buses[j] = buses[j + 1]; // Перестановка
                    buses[j + 1] = temp; // Завершение обмена
                }
            }
        }
    }
}
