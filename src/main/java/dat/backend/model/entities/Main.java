package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

import java.util.ArrayList;

public class Main {

    static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public static void main(String[] args) {

        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);

        Carport carport = BillOfMaterials.buildCarport(new Carport(780, 600), materialArrayList);
        System.out.println(carport.getPartList());


    }

}
