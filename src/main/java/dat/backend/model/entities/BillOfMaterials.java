package dat.backend.model.entities;

import dat.backend.model.services.Calculator;

import java.util.ArrayList;

public class BillOfMaterials {

//    List<Material> materialList = MaterialFacade.getMaterials(connectionPool);

    public static Carport buildCarport(Carport carport, ArrayList<Material> materialList) {


        Part rafterPart = addRafter(carport.getLength(), carport.getWidth(), materialList);
        carport.setPartList(rafterPart);


        return carport;
    }

//                 (height/material.getMaterialQuantity()) % 1
//                 ex 1 :   210/300 = 0,7 / 0,5 = 1,4
//                 ex 2 :   210/250 = 0,84 % 1 =  den rigtige stolpe
//                 ex 3 :   210/220 = 0,95 / 0,5 = 1,9

    //                 (height/material.getMaterialQuantity()) % 1
//                 ex 1 :   220/110 = 0,2 / 0,5 = 0,4 den rigtige stolpe
//                 ex 2 :   220/200 = 0,84 % 1 =
//                 ex 3 :   220/150 = 0,95 / 0,5 = 1,9


    public static Part addRafter(int carportLength, int carportWidth, ArrayList<Material> materialList) {

        Material finalMaterial = null;

//        switch (materialList)

        for (Material material : materialList) {

            // case 1: der findes et materiale der overstiger det ønskede mål
            if (material.getProductVariant().contains("spær") && material.getUnitType().contains("cm") && material.getMaterialQuantity() >= carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (material.getMaterialQuantity() % carportWidth < finalMaterial.getMaterialQuantity() % carportWidth) {    //tjekker hvilket mål der ligger tættest på det ønskede mål, og hvis det "nye" materiale er mere optimalt, erstattes finalMaterial med det "nye" material
                    finalMaterial = material;
                }
            }

            // case 2: der findes IKKE et materiale der overstiger det ønskede mål OG der findes et materiale der kan dække halvdelen af det ønskede mål
            if (material.getProductVariant().contains("spær") && material.getUnitType().contains("cm") && material.getMaterialQuantity() < carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (Calculator.calcRafter(carportLength, carportWidth, material.getMaterialQuantity()) < Calculator.calcRafter(carportLength, carportWidth, finalMaterial.getMaterialQuantity())) {
                    finalMaterial = material;
                }
            }

        }

        int partQuantity = Calculator.calcRafter(carportLength, carportWidth, finalMaterial.getMaterialQuantity());
        Part rafterPart = new Part(finalMaterial, partQuantity);
        return rafterPart;


    }



}
