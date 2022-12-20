package dat.backend.model.services;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Part;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class CarportBuilderTest {

    ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);
    Carport carport = new Carport(780, 600);

    @Test
    void addPoles() {

        Part polePart = CarportBuilder.addPoles(carport.getLength(), carport.getWidth(), carport.getHeight(), materialArrayList);
        Part expectedPart = new Part(new Material(300, "97x97mm.trykimp.Stolpe", "cm", 149.85f, "stolpe"), 6, 899.1f);

        assertEquals(expectedPart, polePart);
    }

}