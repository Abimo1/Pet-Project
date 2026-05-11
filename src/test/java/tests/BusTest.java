package tests;

import bus.Bus;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BusTest {

    @Test
    public void testBusCreation() {
        Bus bus = new Bus.Builder()
                .setNumber("A123BC")
                .setModel("Mercedes")
                .setMileage(15000)
                .build();

        assertEquals("A123BC", bus.getNumber());
        assertEquals("Mercedes", bus.getModel());
        assertEquals(15000, bus.getMileage());
    }

    @Test
    public void testBusToString() {
        Bus bus = new Bus.Builder()
                .setNumber("B456DA")
                .setModel("Volvo")
                .setMileage(20000)
                .build();

        assertEquals("Bus{number='B456DA', model='Volvo', mileage=20000}", bus.toString());
    }

    @Test
    public void testBusBuilderWithDefaultValues() {
        Bus bus = new Bus.Builder().build();

        assertNull(bus.getNumber());
        assertNull(bus.getModel());
        assertEquals(0, bus.getMileage());
    }
}
