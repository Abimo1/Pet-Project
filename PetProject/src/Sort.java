public class Sort {

    public Bus[] sortedBuses(Bus[] buses) {
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getMileage() % 2 == 0) {
                for (int j = i + 1; j < buses.length; j++) {
                    if (buses[j].getMileage() % 2 == 0 && buses[i].getMileage() > buses[j].getMileage()) {
                        Bus a = buses[i];
                        buses[i] = buses[j];
                        buses[j] = a;
                    }
                }
            }
        }
        return buses;
    }
}