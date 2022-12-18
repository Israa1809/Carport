package dat.backend.model.services;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Part;

import java.util.ArrayList;

public class CarportBuilder {

    public static Carport buildCarport(Carport carport, ArrayList<Material> materialList) {

        //Poles
        Part polePart = addPoles(carport.getLength(), carport.getWidth(), carport.getHeight(), materialList);
        carport.addPartFirstTime(polePart);

        Part poleWallPlateBoltsPart = addPoleWallPlateBolts(polePart.getPartQuantity(), materialList);
        carport.addPartFirstTime(poleWallPlateBoltsPart);

        //Beams
        Part beamPart = addBeams(carport.getLength(), carport.getWidth(), materialList);
        carport.addPartFirstTime(beamPart);

        Part beamScrewsPart = addBeamScrews(beamPart.getPartQuantity(), materialList);
        carport.addPartFirstTime(beamScrewsPart);

        Part beamFittingsRightPart = addBeamFittingsRight(beamPart.getPartQuantity(), materialList);
        carport.addPartFirstTime(beamFittingsRightPart);

        Part beamFittingsLeftPart = addBeamFittingsLeft(beamPart.getPartQuantity(), materialList);
        carport.addPartFirstTime(beamFittingsLeftPart);

        //Wall Plates
        Part wallPlatePart = addWallPlate(carport.getLength(), carport.getWidth(), materialList);
        carport.addPartFirstTime(wallPlatePart);

        //Fascia
        // calcFascia sammenligner ud fra en sammenlagt længde, kan udvides så der gives 2 resultater retur - 1 for bredde og 1 for længde
        Part fasciaTopPart = addFascia(carport.getLength(), carport.getWidth(), materialList, "overstern");
        carport.addPartFirstTime(fasciaTopPart);

        Part fasciaBottomPart = addFascia(carport.getLength(), carport.getWidth(), materialList, "understern");
        carport.addPartFirstTime(fasciaBottomPart);

        Part fasciaScrewsPart = addFasciaScrews(carport.getLength(), carport.getWidth(), materialList);
        carport.addPartFirstTime(fasciaScrewsPart);

        //Perforated Tape
        Part perforatedTapePart = addPerforatedTape(carport.getLength(), carport.getWidth(), materialList);
        carport.addPartFirstTime(perforatedTapePart);

        System.out.println(Calculator.calcRoof(780, 620, 600));

        return carport;
    }


    public static Part addBeams(int carportLength, int carportWidth, ArrayList<Material> materialList) {

        Material finalMaterial = null;

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

                } else if (Calculator.calcBeams(carportLength, carportWidth, material.getMaterialQuantity()) < Calculator.calcBeams(carportLength, carportWidth, finalMaterial.getMaterialQuantity())) {
                    finalMaterial = material;
                }
            }

        }

        int partQuantity = Calculator.calcBeams(carportLength, carportWidth, finalMaterial.getMaterialQuantity());
        Part beamsPart = new Part(finalMaterial, partQuantity);
        return beamsPart;

    }

    public static Part addWallPlate(int carportLength, int carportWidth, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {

            // case 1: der findes et materiale der overstiger det ønskede mål
            if (material.getProductVariant().contains("rem") && material.getUnitType().contains("cm") && material.getMaterialQuantity() >= carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (material.getMaterialQuantity() % carportWidth < finalMaterial.getMaterialQuantity() % carportWidth) {    //tjekker hvilket mål der ligger tættest på det ønskede mål, og hvis det "nye" materiale er mere optimalt, erstattes finalMaterial med det "nye" material
                    finalMaterial = material;
                }
            }

            // case 2: der findes IKKE et materiale der overstiger det ønskede mål OG der findes et materiale der kan dække halvdelen af det ønskede mål
            if (material.getProductVariant().contains("rem") && material.getUnitType().contains("cm") && material.getMaterialQuantity() < carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (Calculator.calcWallPlate(carportLength, carportWidth, material.getMaterialQuantity()) < Calculator.calcWallPlate(carportLength, carportWidth, finalMaterial.getMaterialQuantity())) {
                    finalMaterial = material;
                }
            }

        }

        int partQuantity = Calculator.calcWallPlate(carportLength, carportWidth, finalMaterial.getMaterialQuantity());
        Part wallPlatePart = new Part(finalMaterial, partQuantity);
        return wallPlatePart;

    }

    public static Part addFascia(int carportLength, int carportWidth, ArrayList<Material> materialList, String fasciaType) {

        Material finalMaterial = null;

        for (Material material : materialList) {

            // case 1: der findes et materiale der overstiger det ønskede mål
            if (material.getProductVariant().contains(fasciaType) && material.getUnitType().contains("cm") && material.getMaterialQuantity() >= carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (material.getMaterialQuantity() % carportWidth < finalMaterial.getMaterialQuantity() % carportWidth) {    //tjekker hvilket mål der ligger tættest på det ønskede mål, og hvis det "nye" materiale er mere optimalt, erstattes finalMaterial med det "nye" material
                    finalMaterial = material;
                }
            }

            // case 2: der findes IKKE et materiale der overstiger det ønskede mål OG der findes et materiale der kan dække halvdelen af det ønskede mål
            if (material.getProductVariant().contains(fasciaType) && material.getUnitType().contains("cm") && material.getMaterialQuantity() < carportWidth) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (Calculator.calcFascia(carportLength, carportWidth, material.getMaterialQuantity()) < Calculator.calcFascia(carportLength, carportWidth, finalMaterial.getMaterialQuantity())) {
                    finalMaterial = material;
                }
            }

        }

        int partQuantity = Calculator.calcFascia(carportLength, carportWidth, finalMaterial.getMaterialQuantity());
        Part fasciaPart = new Part(finalMaterial, partQuantity);
        return fasciaPart;


    }

    public static Part addPoles(int carportLength, int carportWidth, int carportHeight, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {

            // case 1: der findes et materiale der overstiger det ønskede mål
            if (material.getProductVariant().contains("stolpe") && material.getUnitType().contains("cm") && material.getMaterialQuantity() >= carportHeight) {

                if (finalMaterial == null) {
                    finalMaterial = material;

                } else if (material.getMaterialQuantity() % carportWidth < finalMaterial.getMaterialQuantity() % carportWidth) {    //tjekker hvilket mål der ligger tættest på det ønskede mål, og hvis det "nye" materiale er mere optimalt, erstattes finalMaterial med det "nye" material
                    finalMaterial = material;
                }
            }

        }

        int partQuantity = Calculator.calcPoles(carportLength, carportWidth);
        Part polePart = new Part(finalMaterial, partQuantity);
        return polePart;


    }

    public static Part addPoleWallPlateBolts(int poleQuantity, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("rem") && material.getUnitType().contains("stk") && material.getMaterialName().contains("bolt")) {
                finalMaterial = material;
            }
        }

        int partQuantity = Calculator.calcPoleWallPlateBolts(poleQuantity);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        Part poleWallPlateBoltsPart = new Part(finalMaterial, partQuantity);
        return poleWallPlateBoltsPart;
    }

    public static Part addBeamScrews(int beamsQuantity, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("spær") && material.getUnitType().contains("stk") && material.getMaterialName().contains("skrue")) {
                    finalMaterial = material;
            }
        }

        int partQuantity = Calculator.calcBeamScrews(beamsQuantity);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        Part beamScrewsPart = new Part(finalMaterial, partQuantity);
        return beamScrewsPart;
    }

    public static Part addBeamFittingsRight(int beamsQuantity, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("spær") && material.getUnitType().contains("stk") && material.getMaterialName().contains("universal") && material.getMaterialName().contains("højre")) {
                finalMaterial = material;
            }
        }

        int partQuantity = Calculator.calcBeamFittings(beamsQuantity);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        Part beamFittingsRightPart = new Part(finalMaterial, partQuantity);
        return beamFittingsRightPart;
    }

    public static Part addBeamFittingsLeft(int beamsQuantity, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("spær") && material.getUnitType().contains("stk") && material.getMaterialName().contains("universal") && material.getMaterialName().contains("venstre")) {
                finalMaterial = material;
            }
        }

        int partQuantity = Calculator.calcBeamFittings(beamsQuantity);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        Part beamFittingsLeftPart = new Part(finalMaterial, partQuantity);
        return beamFittingsLeftPart;
    }


    public static Part addFasciaScrews(int carportLength, int carportWidth, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("stern") && material.getUnitType().contains("stk") && material.getMaterialName().contains("skrue")) {
                finalMaterial = material;
            }
        }

        int partQuantity = Calculator.calcFasciaScrews((carportLength * 2) + (carportWidth * 2) * 2);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        Part fasciaScrewsPart = new Part(finalMaterial, partQuantity);
        return fasciaScrewsPart;
    }

    public static Part addPerforatedTape(int carportLength, int carportWidth, ArrayList<Material> materialList) {

        Material finalMaterial = null;

        for (Material material : materialList) {
            if (material.getProductVariant().contains("hulbånd") && material.getUnitType().contains("cm")) {
                finalMaterial = material;
            }
        }

        double partQuantity = Calculator.calcPerforatedTapeInCM(carportLength, carportWidth);

        float devider = (float) partQuantity / finalMaterial.getMaterialQuantity();

        partQuantity = (int) devider;
        if (devider % 1 > 0) {
            partQuantity = partQuantity + 1;
        }

        int intPartQuantity = (int) partQuantity * 2;

        Part perforatedTapePart = new Part(finalMaterial, intPartQuantity);
        return perforatedTapePart;
    }

}


