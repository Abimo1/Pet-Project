package bus;

public class SortByMileage implements SortStrategy {

    @Override
    public void sort(Bus[] buses) {

        for (int i = 0; i < buses.length - 1; i++) {

            for (int j = 0; j < buses.length - i - 1; j++) {

                if (buses[j].getMileage() > buses[j + 1].getMileage()) {

                    Bus temp = buses[j];
                    buses[j] = buses[j + 1];
                    buses[j + 1] = temp;
                }
            }
        }
    }
}
