package dat.backend.model.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calcPoles() {                  // stolper
        int expected = 6;
        int actual = Calculator.calcPoles(780, 600);
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
        int actual = Calculator.calcBeams(780, 600, 600);
        assertEquals(expected, actual);
    }

    @Test
    void calcBeamScrews() {             // skruer til spær
        int expected = 288;
        int actual = Calculator.calcBeamScrews(16);
        assertEquals(expected, actual);
    }

    @Test
        // beslag til spær - højrevendt eller venstrevendt
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
        double expected = Math.sqrt(Math.pow(780 - 160, 2) + Math.pow(600 - 70, 2));
        double actual = Calculator.calcPerforatedTapeInCM(780, 600);
        assertEquals(expected, actual);
    }

    @Test
        // stern - over eller under
    void calcFascia() {                 // *skal i virkeligheden køres én gang på hver
        int expected = 8;
        int actual = Calculator.calcFascia(780, 600, 540);
        assertEquals(expected, actual);
    }

    @Test
        // skruer til stern - over og under
    void calcFasciaScrews() {
        //carport length = 780 cm and carport width = 600 cm);
        int fullFasciaLength1 = (780 * 2 + 600 * 2) * 2;        // 5520 cm
        int fullFasciaLength2 = ((780 * 2) + (600 * 2)) * 2;

        assertEquals(fullFasciaLength1, fullFasciaLength2);

        // den fulde længde divideres med intervallet på 55 cm mellem hvert spær
        // der lægges en ekstra til til sidst, da det forrige udregner mellemrum, og der skal være en skrue efter sidste mellemrum
        // der ganges med 2, så der kan sættes 2 skruer hver gang sternen krydser et spær
        int expected = ((fullFasciaLength1 / 55) + 1) * 2;
        int actual = Calculator.calcFasciaScrews(fullFasciaLength1);
        assertEquals(expected, actual);
    }

    @Test
    void calcRoof() {                   // tag
        int expected = 9;
        int actual = Calculator.calcRoof(780, 600, 600);
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

    @Test
    void calcShedPoles() {             // stolper til skur

//       boolean experiment = ((600-70)%265) == 0;
//       assertEquals(true, experiment);

        // TEST 1
        int expected1 = 8;                                // 1130 i width = 7 stolper + 1 til dør dvs = 8 stolper
        int actual1 = Calculator.calcShedPoles(1130);
        assertEquals(expected1, actual1);

        // TEST 2
        int expected2 = 5;                                // 600 i width = 4 stolper + 1 til dør dvs = 5 stolper
        int actual2 = Calculator.calcShedPoles(600);
        assertEquals(expected2, actual2);

        // TEST 3
        int expected3 = 3;                                // 335 i width = 2 stolper + 1 til dør dvs = 3 stolper
        int actual3 = Calculator.calcShedPoles(335);
        assertEquals(expected3, actual3);

        // TEST 4
        int expected4 = 8;                                // 870 i width = 7 stolper + 1 til dør dvs = 8 stolper
        int actual4 = Calculator.calcShedPoles(870);
        assertEquals(expected4, actual4);

        // TEST 5
        int expected5 = 5;                                // 470 i width = 4 stolper + 1 til dør dvs = 5 stolper
        int actual5 = Calculator.calcShedPoles(470);
        assertEquals(expected5, actual5);

        // TEST 6
        int expected6 = 8;                                // 1000 i width = 7 stolper + 1 til dør dvs = 8 stolper
        int actual6 = Calculator.calcShedPoles(1000);
        assertEquals(expected6, actual6);

        // TEST 7
        int expected7 = 9;                                // 1200 i width = 8 stolper + 1 til dør dvs = 9 stolper
        int actual7 = Calculator.calcShedPoles(1200);
        assertEquals(expected7, actual7);

    }

    @Test
    void calcShedFrame() {             // ramme til skur
        // der skal være 1 øverst, 1 i midten og 1 nederst, men 2 af de øverste erstattes af rem
        int expected = 16;       // 530 cm = 2 * 270 cm og det er * 6 = 12 og 210 cm = 4 dvs i alt har vi brug for 16
        int actual = Calculator.calcShedFrame(780, 270);

        assertEquals(expected, actual);

    }

    @Test
    void calcShedCladding() {             // beklædning til skur

        int materialWidth = 20;

        int carportWidth = 600;
        int standoff = 70;
        int carportInnerWidth = carportWidth - standoff;

        int shedLength = 210;

        int fullShedCirc = (carportInnerWidth * 2) + (shedLength * 2);  // 1480 ved carport på 780 * 600

        int shedCladding = fullShedCirc / materialWidth;

        int expected = shedCladding;       // 74

//        assertEquals(expected, shedCladding);

        int actual = Calculator.calcShedCladding(600);

        assertEquals(expected, actual);

    }

    @Test
    void calcShedDoorZ() {             // Z til dør på skur
        int doorWidth = 80;
        int doorLength = 180;
        int doorLengthWithoutStandOff = doorLength - (2 * 35);
        int materialLength = 420;

        double c = Math.sqrt(Math.pow(doorLengthWithoutStandOff, 2) + Math.pow(doorWidth, 2));
        double fullLengthZ = c + (2 * doorWidth);

        double divider = fullLengthZ / materialLength;

        if (divider % 1 > 0) {
            divider = (int) divider + 1;
        }

        int expected = (int) divider;
        double actual = Calculator.calcShedDoorZ(materialLength);

        assertEquals(expected, actual);

    }


}