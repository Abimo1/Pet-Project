package Bus;

import Bus.Bus.BusBuilder;
import java.io.PrintStream;

public class BusTest {
    public static void main(String[] args) {
        Bus bus1 = BusBuilder.newInstance().setNumber("101").setModel("Mercedes").setMileage("50000").build();
        Bus bus2 = BusBuilder.newInstance().setNumber("20").setModel("Volvo").setMileage("120000").build();
        SortStrategy numberSort = new SortByNumber();
        PrintStream var10000 = System.out;
        int var10001 = numberSort.compare(bus1, bus2);
        var10000.println("Тест номера: " + (var10001 > 0 ? "Пройден" : "Ошибка"));
        SortStrategy modelSort = new SortByModel();
        var10000 = System.out;
        var10001 = modelSort.compare(bus1, bus2);
        var10000.println("Тест модели: " + (var10001 < 0 ? "Пройден" : "Ошибка"));
        SortStrategy mileageSort = new SortByMileage();
        var10000 = System.out;
        var10001 = mileageSort.compare(bus1, bus2);
        var10000.println("Тест пробега: " + (var10001 < 0 ? "Пройден" : "Ошибка"));
    }
}