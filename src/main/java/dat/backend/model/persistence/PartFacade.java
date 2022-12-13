package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

public class PartFacade {

    public static int addParts(Carport carport, ConnectionPool connectionPool) {
        return PartMapper.addParts(carport, connectionPool);

    }
}
