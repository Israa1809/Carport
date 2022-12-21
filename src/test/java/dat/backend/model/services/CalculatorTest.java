package dat.backend.model.services;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcPoles() {                  // stolper
        int expected = 6;
        int actual = Calculator.calcPoles(780,600);
        assertEquals(expected, actual);
    }

    @Test
    void calcWallPlate() {              // rem
        int expected = 4;
        int actual = Calculator.calcWallPlate(780, 600, 600);
        assertEquals(expected, actual);
    }

    @Test
    void calcPoleWallPlateBolts() {     // bolte til rem
        int expected = 32;
        int actual = Calculator.calcPoleWallPlateBolts(16);
        assertEquals(expected, actual);
    }

    @Test
    void calcBeams() {                   // spær
        int expected = 16;
        int actual = Calculator.calcBeams(780,600,600);
        assertEquals(expected, actual);
    }

    @Test
    void calcBeamScrews() {             // skruer til spær
        int expected = 288;
        int actual = Calculator.calcBeamScrews(16);
        assertEquals(expected, actual);
    }

    @Test                               // beslag til spær - højrevendt eller venstrevendt
    void calcBeamFittings() {           // *skal i virkeligheden køres én gang på hver
        int expected = 32;
        int actual = Calculator.calcBeamFittings(16);
        assertEquals(expected, actual);
    }

    @Test
    void calcPerforatedTapeInCM() {     // hulbånd

        double tempLengthWithoutStandoff = 780 - 160;

        double tempLengthToThePowerOfTwoManual = tempLengthWithoutStandoff * tempLengthWithoutStandoff;
        double tempLengthToThePowerOfTwoSystem = Math.pow(tempLengthWithoutStandoff, 2);

        assertEquals(tempLengthToThePowerOfTwoManual, tempLengthToThePowerOfTwoSystem);

        double tempWidthWithoutStandoff = 600 - 70;
        double tempWidthToThePowerOfTwoSystem = Math.pow(tempWidthWithoutStandoff, 2);

        double cToThePowerOfTwo = tempLengthToThePowerOfTwoSystem + tempWidthToThePowerOfTwoSystem;
        double cV1 = Math.sqrt(cToThePowerOfTwo);

        double a2plusb2 = Math.pow(tempLengthWithoutStandoff, 2) + Math.pow(tempWidthWithoutStandoff, 2);

        assertEquals(cToThePowerOfTwo, a2plusb2);

        double cV2 = Math.sqrt(a2plusb2);

        assertEquals(cV1, cV2);

        // a i anden + b i anden = c i anden
        double expected = Math.sqrt(Math.pow(780-160, 2) + Math.pow(600-70, 2));
        double actual = Calculator.calcPerforatedTapeInCM(780,600);
        assertEquals(expected, actual);
    }

    @Test                               // stern - over eller under
    void calcFascia() {                 // *skal i virkeligheden køres én gang på hver
        int expected = 8;
        int actual = Calculator.calcFascia(780,600,540);
        assertEquals(expected, actual);
    }

    @Test                               // skruer til stern - over og under
    void calcFasciaScrews() {
        //carport length = 780 cm and carport width = 600 cm);
        int fullFasciaLength1 = (780 * 2 + 600 * 2) * 2;        // 5520 cm
        int fullFasciaLength2 = ((780 * 2) + (600 * 2)) * 2;

        assertEquals(fullFasciaLength1, fullFasciaLength2);

        // den fulde længde divideres med intervallet på 55 cm mellem hvert spær
        // der lægges en ekstra til til sidst, da det forrige udregner mellemrum, og der skal være en skrue efter sidste mellemrum
        // der ganges med 2, så der kan sættes 2 skruer hver gang sternen krydser et spær
        int expected = ((fullFasciaLength1/55)+1)*2;
        int actual = Calculator.calcFasciaScrews(fullFasciaLength1);
        assertEquals(expected, actual);
    }

    @Test
    void calcRoof() {                   // tag
        int expected = 9;
        int actual = Calculator.calcRoof(780,600,600);
        assertEquals(expected, actual);
    }

    @Test
    void calcRoofScrews() {             // skruer til tag
        //carport length = 780 cm and carport width = 600 cm);

        int lengthInMeters = 780 / 100;
        int widthInMeters = 600 / 100;
        int squareMeterOfRoof = lengthInMeters * widthInMeters;

        // byggevejledningen fra Fog foreslår 12 skruer per kvadratmeter tag
        int expected = 12 * squareMeterOfRoof;

        int actual = Calculator.calcRoofScrews(780, 600);

        assertEquals(expected, actual);

    }

}