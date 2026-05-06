package Bus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Bus.Bus.BusBuilder;
import java.io.PrintStream;



public class BusTest {

    @Test
    void testNumberSort() {
        Bus bus1 = BusBuilder.newInstance().setNumber("101").build();
        Bus bus2 = BusBuilder.newInstance().setNumber("20").build();
        SortStrategy numberSort = new SortByNumber();

        assertTrue(numberSort.compare(bus1, bus2) > 0, "Автобус 101 должен быть после 20");
    }

    @Test
    void testModelSort() {
        Bus bus1 = BusBuilder.newInstance().setModel("Mercedes").build();
        Bus bus2 = BusBuilder.newInstance().setModel("Volvo").build();
        SortStrategy modelSort = new SortByModel();

        assertTrue(modelSort.compare(bus1, bus2) < 0, "Mercedes должен быть перед Volvo");
    }
}