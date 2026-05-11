package tests;

import bus.DataValidator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DataValidatorTest {

    private DataValidator validator = new DataValidator();

    @Test
    public void testValidateBusNumber() {
        assertTrue(validator.validateBusNumber("A123BC"));
        assertFalse(validator.validateBusNumber(" "));
        assertFalse(validator.validateBusNumber(null));
    }

    @Test
    public void testValidateBusModel() {
        assertTrue(validator.validateBusModel("Mercedes"));
        assertFalse(validator.validateBusModel(" "));
        assertFalse(validator.validateBusModel(null));
    }

    @Test
    public void testValidateBusMileage() {
        assertTrue(validator.validateBusMileage(10000));
        assertFalse(validator.validateBusMileage(-500));
    }

    @Test
    public void testValidateBusData() {
        assertTrue(validator.validateBusData("A123BC", "Mercedes", 10000));
        assertFalse(validator.validateBusData(" ", "Mercedes", 10000));
        assertFalse(validator.validateBusData("A123BC", "Mercedes", -500));
    }
}
