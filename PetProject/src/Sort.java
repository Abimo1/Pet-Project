public class Sort {
    private Bus[] buses;

    public Sort(Bus[] buses) {
        this.buses = buses;
    }

    public Bus[] sortedNumber() {
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getNumber() % 2 == 0) {
                for (int j = i + 1; j < buses.length; j++) {
                    if (buses[j].getNumber() % 2 == 0 && buses[i].getNumber() > buses[j].getNumber()) {
                        Bus a = buses[i];
                        buses[i] = buses[j];
                        buses[j] = a;
                    }
                }
            }
        }
        return buses;
    }

    public Bus[] sortedModel() {
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getModel() % 2 == 0) {
                for (int j = i + 1; j < buses.length; j++) {
                    if (buses[j].getModel() % 2 == 0 && buses[i].getModel() > buses[j].getModel()) {
                        Bus a = buses[i];
                        buses[i] = buses[j];
                        buses[j] = a;
                    }
                }
            }
        }
        return buses;
    }

    public Bus[] sortedSource() {
        for (int i = 0; i < buses.length; i++) {
            if (buses[i].getSource() % 2 == 0) {
                for (int j = i + 1; j < buses.length; j++) {
                    if (buses[j].getSource() % 2 == 0 && buses[i].getSource() > buses[j].getSource()) {
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