package tests;

import bus.Bus;
import bus.SortStrategy;
import bus.SortByNumber;
import bus.SortByModel;
import bus.SortByMileage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SortStrategyTest {

    @Test
    public void testSortByNumber() {
        Bus[] buses = {
                new Bus.Builder().setNumber("C789EF").setModel("Iveco").setMileage(25000).build(),
                new Bus.Builder().setNumber("A123BC").setModel("Mercedes").setMileage(15000).build(),
                new Bus.Builder().setNumber("B456DA").setModel("Volvo").setMileage(20000).build()
        };

        SortStrategy sortStrategy = new SortByNumber();
        sortStrategy.sort(buses);

        assertEquals("A123BC", buses[0].getNumber());
        assertEquals("B456DA", buses[1].getNumber());
        assertEquals("C789EF", buses[2].getNumber());
    }

    @Test
    public void testSortByModel() {
        Bus[] buses = {
                new Bus.Builder().setNumber("C789EF").setModel("Iveco").setMileage(25000).build(),
                new Bus.Builder().setNumber("A123BC").setModel("Mercedes").setMileage(15000).build(),
                new Bus.Builder().setNumber("B456DA").setModel("Volvo").setMileage(20000).build()
        };

        SortStrategy sortStrategy = new SortByModel();
        sortStrategy.sort(buses);

        assertEquals("Iveco", buses[0].getModel());
        assertEquals("Mercedes", buses[1].getModel());
        assertEquals("Volvo", buses[2].getModel());
    }

    @Test
    public void testSortByMileage() {
        Bus[] buses = {
                new Bus.Builder().setNumber("C789EF").setModel("Iveco").setMileage(25000).build(),
                new Bus.Builder().setNumber("A123BC").setModel("Mercedes").setMileage(15000).build(),
                new Bus.Builder().setNumber("B456DA").setModel("Volvo").setMileage(20000).build()
        };

        SortStrategy sortStrategy = new SortByMileage();
        sortStrategy.sort(buses);

        assertEquals(15000, buses[0].getMileage());
        assertEquals(20000, buses[1].getMileage());
        assertEquals(25000, buses[2].getMileage());
    }
}
