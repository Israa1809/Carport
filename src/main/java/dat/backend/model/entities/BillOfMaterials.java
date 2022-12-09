package dat.backend.model.entities;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

import dat.backend.model.services.Calculator;

import java.util.ArrayList;
import java.util.List;

public class BillOfMaterials {

//    List<Material> materialList = MaterialFacade.getMaterials(connectionPool);

    public static Carport buildCarport(Carport carport, ArrayList<Material> materialList) {


        Part beamPart = addBeams(carport.getLength(), carport.getWidth(), carport.getHeight(), materialList);
        carport.setPartList(beamPart);


        return carport;
    }


    public static Part addBeams(int length, int width, int height, ArrayList<Material> materialList) {
        int partQuantity = Calculator.calcBeams(length, width, height);
        Material finalMaterial = null;

        for (Material material : materialList) {

            if(material.getProductVariant().contains("stolpe")){

                if(finalMaterial == null){
                    finalMaterial = material;
                }
// skal være længere end height
                else if(material.getMaterialQuantity()%height < finalMaterial.getMaterialQuantity()%height){
                    finalMaterial = material;
                }
            }

        }



        Part part = new Part(finalMaterial, partQuantity);
        return part;


    }


}
