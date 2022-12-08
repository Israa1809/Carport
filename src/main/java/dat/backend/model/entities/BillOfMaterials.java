package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

import dat.backend.model.services.Calculator;

import java.util.List;

public class BillOfMaterials {

    private static ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    private static List<Material> materialList = MaterialFacade.getMaterials(connectionPool);

    public static Carport buildCarport(Carport carport) {

        Part beamPart = addBeams(carport.getLength(), carport.getWidth(), carport.getHeight());
        carport.setPartList(beamPart);


        return carport;
    }


    public static Part addBeams(int length, int width, int height) {
        int partQuantity = Calculator.calcBeams(length, width, height);
        Material finalMaterial = null;

        for (Material material : materialList) {

            if(material.getProductVariant().contains("stolpe")){

                if(finalMaterial == null){
                    finalMaterial = material;
                }

                else if(material.getMaterialQuantity()%height < finalMaterial.getMaterialQuantity()%height){
                    finalMaterial = material;
                }
            }

        }



        Part part = new Part(finalMaterial, partQuantity);
        return part;


    }


}
