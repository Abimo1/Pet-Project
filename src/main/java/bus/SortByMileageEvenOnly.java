package bus;

import java.util.ArrayList;
import java.util.List;

public class SortByMileageEvenOnly implements SortStrategy {

    @Override
    public void sort(Bus[] buses) {

        List<Integer> evenIndexes = new ArrayList<>();
        List<Integer> evenValues = new ArrayList<>();

        // 1. собираем чётные значения + их позиции
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getMileage() % 2 == 0) {
                evenIndexes.add(i);
                evenValues.add(buses[i].getMileage());
            }
        }

        // 2. сортируем только значения (bubble sort)
        for (int i = 0; i < evenValues.size() - 1; i++) {
            for (int j = 0; j < evenValues.size() - i - 1; j++) {
                if (evenValues.get(j) > evenValues.get(j + 1)) {
                    int tmp = evenValues.get(j);
                    evenValues.set(j, evenValues.get(j + 1));
                    evenValues.set(j + 1, tmp);
                }
            }
        }

        // 3. возвращаем обратно в те же позиции
        for (int i = 0; i < evenIndexes.size(); i++) {
            int index = evenIndexes.get(i);

            buses[index] = new Bus.Builder()
                    .setNumber(buses[index].getNumber())
                    .setModel(buses[index].getModel())
                    .setMileage(evenValues.get(i))
                    .build();
        }
    }
}
