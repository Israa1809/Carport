package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

import java.util.ArrayList;
import java.util.List;

public class CarportFacade {

    public static int addCarport(Carport carport, int customerId, ConnectionPool connectionPool) {
        return CarportMapper.addCarport(carport, customerId, connectionPool);

    }

    public static Carport getCarportById(int carportId, ConnectionPool connectionPool){
        return CarportMapper.getCarportById(carportId, connectionPool);
    }
    public static ArrayList<Carport> getCarportList(ConnectionPool connectionPool){
        return CarportMapper.getCarportList(connectionPool);
    }


}
