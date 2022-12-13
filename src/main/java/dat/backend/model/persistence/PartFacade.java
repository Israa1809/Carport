package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

public class PartFacade {

    public static void addParts(Carport carport, ConnectionPool connectionPool) {
         PartMapper.addParts(carport, connectionPool);

    }
}
