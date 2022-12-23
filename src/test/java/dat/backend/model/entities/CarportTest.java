package dat.backend.model.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CarportTest {

    Carport carport;

    @BeforeEach
    void setUp() {
        carport = new Carport(780, 600, false);
    }

    @Test
    void addPartFirstTime() {

        Part polePart = new Part(new Material(300, "97x97mm.trykimp.Stolpe", "cm", 149.85f, "stolpe"), 6, 899.1f);
        Part beamPart = new Part(new Material(600, "45x195mm.spærtræubh.", "cm", 467.7f, "rem - spær"), 16, 7483.2f);

        int actualSize = carport.getPartList().size();

        assertEquals(0, actualSize);

        carport.addPartFirstTime(polePart);
        carport.addPartFirstTime(beamPart);

        actualSize = carport.getPartList().size();

        assertEquals(2, actualSize);

        String expectedPartName = beamPart.getMaterial().getMaterialName();
        String actualPartName = carport.getPartList().get(1).getMaterial().getMaterialName();

        assertEquals(expectedPartName, actualPartName);

        float expectedFullPrice = polePart.getPartPrice() + beamPart.getPartPrice();
        float actualFullPrice = carport.getMaterialFullPrice();

        assertEquals(expectedFullPrice, actualFullPrice);

    }

    @Test
    void setPartList() {

        ArrayList<Part> materialList = new ArrayList<>();

        Part polePart = new Part(new Material(300, "97x97mm.trykimp.Stolpe", "cm", 149.85f, "stolpe"), 6, 899.1f);
        Part beamPart = new Part(new Material(600, "45x195mm.spærtræubh.", "cm", 467.7f, "rem - spær"), 16, 7483.2f);

        materialList.add(polePart);
        materialList.add(beamPart);

        int actualSize = carport.getPartList().size();

        assertEquals(0, actualSize);

        carport.setPartList(materialList);

        actualSize = carport.getPartList().size();

        assertEquals(2, actualSize);

        String expectedPartName = beamPart.getMaterial().getMaterialName();
        String actualPartName = carport.getPartList().get(1).getMaterial().getMaterialName();

        assertEquals(expectedPartName, actualPartName);

        float expectedFullPrice = polePart.getPartPrice() + beamPart.getPartPrice();
        float actualFullPrice = carport.getMaterialFullPrice();

        assertEquals(expectedFullPrice, actualFullPrice);

    }

}