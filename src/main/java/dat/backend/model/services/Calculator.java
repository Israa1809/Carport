package dat.backend.model.services;

public class Calculator {

    public static int calcBeams(int length, int width) {     //'beams' er 'stolper' på dansk

        int resLength;
        int resWidth;

        float lengthDiv = (length-160)/310f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis længden overstiger 310 cm skal der indsættes en ekstra stolpe
        float widthDiv = (width-70)/530f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis bredden overstiger 530 cm skal der indsættes en ekstra stolpe

        resLength = (int) lengthDiv + 1;
        if(lengthDiv%1 > 0){
            resLength = resLength + 1;
        }

        resWidth =  (int) widthDiv + 1;
        if(widthDiv%1 > 0){
            resWidth = resWidth + 1;
        }

        int resTotal = resLength * resWidth;

        return resTotal;
    }

    // Udregner spær - 15 total på given vejledning
    public static int rafter(int carportLength, int carportWidth, int materialLength) {
        int interval = 55;
        int numberOfRows;
        int devider;
        int numberOfMaterial;

        //finder antallet af spær ud fra interval på 55cm
        float lengthDiv = (carportLength / interval) + 1;
        if (lengthDiv % 1 > 0) {
            numberOfRows = (int) lengthDiv + 1;
        } else {
            numberOfRows = (int) lengthDiv;
        }

        // Beregner antallet af gange carportens bredte overstiger materialets længde
        float widthDiv = carportWidth / materialLength;
        if (lengthDiv % 1 > 0) {
            devider = (int) widthDiv + 1;
        } else {
            devider = (int) widthDiv;
        }

        // finder antallet af et givet materiale med "meterialLength" pr række af spær
        numberOfMaterial = numberOfRows * devider;

        return numberOfMaterial;
    }

    public static int wallPlate(int carportLength, int carportWidth, int materialLength){
        float wpLength;
        float wpWidth;
        float wallPlateMaterial;

        wpLength = carportLength / materialLength;
        wpWidth = carportWidth / materialLength;
        wallPlateMaterial = wpWidth + wpLength;

        if(wallPlateMaterial % 1 > 0){
            wallPlateMaterial = wallPlateMaterial + 1;
        }
        return (int)wallPlateMaterial;
    }
}
