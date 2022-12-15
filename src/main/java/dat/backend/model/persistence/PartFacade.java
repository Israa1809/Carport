package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Part;

import java.util.ArrayList;

public class PartFacade {

    public static void addParts(Carport carport, ConnectionPool connectionPool) {
        PartMapper.addParts(carport, connectionPool);
    }

    public static void getPartListbyCarportId(Carport carport, ConnectionPool connectionPool) {
        PartMapper.getPartListbyCarportId(carport, connectionPool);
    }

    public static void deletePartListByCarportID(int carport_id, ConnectionPool connectionPool){
        PartMapper.deletePartListByCarportID(carport_id, connectionPool);
    }

    public static void updatePartList(Carport carport, ConnectionPool connectionPool){
        PartMapper.updatePartList(carport, connectionPool);
    }
}
