package dat.backend.model.persistence;

import dat.backend.model.entities.Material;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MaterialFacade {

    public static ArrayList<Material> getMaterials(ConnectionPool connectionPool){
        return MaterialMapper.getMaterials(connectionPool);
    }


    public static void deleteMaterialById(int materialId, ConnectionPool connectionPool){
        MaterialMapper.deleteMaterialById(materialId, connectionPool);
    }




}
