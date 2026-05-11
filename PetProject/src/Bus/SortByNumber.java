package bus;

public class SortByNumber implements SortStrategy {
    @Override
    public void sort(Bus[] buses) {
        for (int i = 0; i < buses.length - 1; i++) {
            for (int j = 0; j < buses.length - i - 1; j++) {
                if (buses[j].getNumber().compareTo(buses[j + 1].getNumber()) > 0) {
                    Bus temp = buses[j];
                    buses[j] = buses[j + 1];
                    buses[j + 1] = temp;
                }
            }
        }
    }
}
