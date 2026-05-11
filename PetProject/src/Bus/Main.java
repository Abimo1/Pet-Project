package Bus;

import Bus.Bus.BusBuilder;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        Bus b1 = BusBuilder.newInstance().setNumber("20").setModel("Z-Bus").setMileage("1000").build();
        Bus b2 = BusBuilder.newInstance().setNumber("10").setModel("A-Bus").setMileage("5000").build();
        Bus b3 = BusBuilder.newInstance().setNumber("30").setModel("M-Bus").setMileage("200").build();
        Bus[] buses = new Bus[]{b1, b2, b3};
        System.out.println("Сортировка по номеру:");
        BusSorter.sort(buses, new SortByNumber());
        printBuses(buses);
        System.out.println("\nСортировка по модели:");
        BusSorter.sort(buses, new SortByModel());
        printBuses(buses);
    }

    private static void printBuses(Bus[] buses) {
        for(Bus b : buses) {
            PrintStream var10000 = System.out;
            int var10001 = b.getNumber();
            var10000.println(var10001 + " | " + b.getModel() + " | " + b.getMileage());
        }

    }
}
