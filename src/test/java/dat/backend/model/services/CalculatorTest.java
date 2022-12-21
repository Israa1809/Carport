package dat.backend.model.services;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcPoles() {      // stolper
        int expected = 6;
        int actual = Calculator.calcPoles(780,600);
        assertEquals(expected, actual);
    }

    @Test
    void calcBeams() {      // spær
        int expected = 16;
        int actual = Calculator.calcBeams(780,600,600);
        assertEquals(expected, actual);
    }

    @Test
    void calcWallPlate() {      // rem
        int expected = 4;
        int actual = Calculator.calcWallPlate(780, 600, 600);
        assertEquals(expected, actual);
    }

    @Test
    void calcBeamScrews() {      // skruer til spær
        int expected = 288;
        int actual = Calculator.calcBeamScrews(16);
        assertEquals(expected, actual);
    }

    @Test                            // beslag til spær - højrevendt eller venstrevendt
    void calcBeamFittings() {        // *skal i virkeligheden køres én gang på hver
        int expected = 32;
        int actual = Calculator.calcBeamFittings(16);
        assertEquals(expected, actual);
    }

    @Test                            // stern - over eller under
    void calcFascia() {             // *skal i virkeligheden køres én gang på hver
        int expected = 8;
        int actual = Calculator.calcFascia(780,600,540);
        assertEquals(expected, actual);
    }

    @Test
    void calcRoof() {      // tag
        int expected = 9;
        int actual = Calculator.calcRoof(780,600,600);
        assertEquals(expected, actual);
    }
}