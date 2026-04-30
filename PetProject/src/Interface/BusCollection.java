package Interface;

public class BusCollection {
    private Bus[] buses;
    private int size;
    private static final int INITIAL_SIZE = 10;


    public BusCollection() {
        this.buses = new Bus[INITIAL_SIZE];
        this.size = 0;
    }

    public void add(Bus bus) {
        if (size >= buses.length) {
            resize();
        }
        buses[size++] = bus;
    }

    public void resize() {
        Bus[] newBuses = new Bus[buses.length * 3 / 2 + 1];
        arrayCopy(buses, newBuses);
        buses = newBuses;
    }

    public Bus[] arrayCopy(Bus[] buses, Bus[] newBuses) {
        if (buses.length >= newBuses.length)
            throw new ArrayIndexOutOfBoundsException("Второй массив меньше первого.");

        for (int i = 0; i < buses.length; i++) {
            newBuses[i] = buses[i];
        }
        return newBuses;
    }

    public Bus get(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Выход за пределы массива.");

        return buses[index];
    }

    public int size() {
        return size;
    }
}
