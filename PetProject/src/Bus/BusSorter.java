package Bus;

public class BusSorter {
    public static void sort(Bus[] buses, SortStrategy strategy) {
        for(int i = 0; i < buses.length - 1; ++i) {
            for(int j = 0; j < buses.length - i - 1; ++j) {
                if (strategy.compare(buses[j], buses[j + 1]) > 0) {
                    Bus temp = buses[j];
                    buses[j] = buses[j + 1];
                    buses[j + 1] = temp;
                }
            }
        }

    }
}