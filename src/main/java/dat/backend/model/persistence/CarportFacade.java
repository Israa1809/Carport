package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;

public class CarportFacade {

    public static int addCarport(Carport carport, int customerId, ConnectionPool connectionPool) {
        return CarportMapper.addCarport(carport, customerId, connectionPool);

    }

    public static Carport getCarportById(int carportId, ConnectionPool connectionPool){
        return CarportMapper.getCarportById(carportId, connectionPool);
    }
}
