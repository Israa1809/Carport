package dat.backend.model.services;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcRoof() {
        int calc = Calculator.calcRoof(780,300,360);
        int expected = 9;

        assertEquals(calc, expected);
    }
}