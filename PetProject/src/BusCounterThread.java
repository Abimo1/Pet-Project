package bus;

public class BusCounterThread extends Thread {

    private final Bus[] buses;
    private final int targetMileage;

    private int result = 0;

    public BusCounterThread(Bus[] buses, int targetMileage) {
        this.buses = buses;
        this.targetMileage = targetMileage;
    }

    @Override
    public void run() {
        for (Bus bus : buses) {
            if (bus.getMileage() == targetMileage) {
                result++;
            }
        }
    }

    public int getResult() {
        return result;
    }
}