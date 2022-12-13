package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Part;

import java.util.ArrayList;

public class PartFacade {

    public static void addParts(Carport carport, ConnectionPool connectionPool) {
        PartMapper.addParts(carport, connectionPool);
    }

    public static ArrayList<Part> getPartListbyCarportId(int carportId, ConnectionPool connectionPool) {
        return PartMapper.getPartListbyCarportId(carportId, connectionPool);
    }
}
