package dat.backend.model.services;

public class Calculator {

    public static int calcPoles(int carportLength, int carportWidth) {     //'poles' er 'stolper' på dansk

        // alle de følgende antagelser er baseret på en skitse af en standard carport på 780 cm x 600 cm udleveret af Fog

        // vi har besluttet at længde er det man også ville kalde dybden på carporten, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 7,8 m
        // vi har besluttet at bredden er målet fra højre til venstre, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 6,0 m

        // vi har besluttet at længde og bredde måles i cm, og vi antager at hvis længden overstiger 310 cm skal der indsættes en ekstra stolpe
        float lengthInterval = 310f;
        // vi har besluttet at længde og bredde måles i cm, og vi antager at hvis bredden overstiger 530 cm skal der indsættes en ekstra stolpe
        float widthInterval = 530f;
        // vi har besluttet at der lægges 100 cm til foran på carporten samt 60 cm ved bagenden af carporten
        int lengthStandOff = 160;
        // vi har besluttet at der lægges 35 cm til i hver side af carporten
        int widthStandOff = 70;
        int resLength;
        int resWidth;

        float lengthDiv = (carportLength-lengthStandOff)/lengthInterval;
        float widthDiv = (carportWidth-widthStandOff)/widthInterval;

        // der tilføjes en ekstra stolpe efter længden er divideret med intervallet, da den forrige linje udregner antallet af mellemrum, ikke antallet af stolper
        // og der skal dermed sættes en stolpe efter sidste mellemrum
        resLength = (int) lengthDiv + 1;
        // hvis der var en rest da carportens længde blev divideret med det givne interval, skal der tilføjes en ekstra stolpe, så intervallet ikke overstiges
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
    public static int calcBeams(int carportLength, int carportWidth, int materialLength) {      //'beams' er 'spær' på dansk
        float interval = 55f;
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
        float widthDiv = (float) carportWidth / materialLength;
        if (widthDiv % 1 > 0) {
            devider = (int) widthDiv + 1;
        } else {
            devider = (int) widthDiv;
        }

        // finder antallet af et givet materiale med "meterialLength" pr række af spær
        numberOfMaterial = numberOfRows * devider;

        return numberOfMaterial;
    }

    //Udregner 1x stern over/under
    public static int calcFascia(int carportLength, int carportWidth, int materialLength){       //'fascia' er 'stern' på dansk
        float faLength;
        float faWidth;
        int fasciaMatieral;

        faLength = (float)carportLength / materialLength;
        faWidth = (float)carportWidth / materialLength;


        if(faLength % 1 > 0){
            faLength = faLength + 1;
        }
        if(faWidth % 1 > 0){
            faWidth = faWidth + 1;
        }

        fasciaMatieral = ((int)faWidth + (int)faLength) * 2;

        return fasciaMatieral;
    }

    public static int calcWallPlate(int carportLength, int carportWidth, int materialLength) {     //'wallPlate' er 'rem' på dansk

        float widthInterval = 530f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis bredden overstiger 530 cm skal der indsættes en ekstra stolpe
        float wpLength;
        int widthStandOff = 70;
        int resWidth;
        int resTotal;

        float widthDiv = (carportWidth - widthStandOff) / widthInterval;

        resWidth = (int) widthDiv + 1;
        if (widthDiv % 1 > 0) {
            resWidth = resWidth + 1;
        }

        wpLength = (float)carportLength / materialLength;

        if(wpLength % 1 > 0){
            wpLength = wpLength + 1;
        }

        resTotal = resWidth * (int)wpLength;

        return resTotal;
    }

    public static int calcBeamScrews(int beamsQuantity){
        return beamsQuantity * 9 * 2;
    }

    public static int calcBeamFittings(int beamsQuantity) {
        return beamsQuantity * 2;
    }

    public static int calcPoleWallPlateBolts(int poleQuantity) {
        return poleQuantity * 2;
    }


    public static int calcFasciaScrews(int fasciaLength) {
        return ((fasciaLength/55)+1)*2;    //400cm / 100 = 4 + 1 = 5 * 2 = 10
    } //Vi har vedtaget at der ved over- og understern bruges 2 skruer per pr spær interval

    public static double calcPerforatedTapeInCM(int carportLength, int carportWidth) {
        int tempCaportLength = carportLength - 160;
        int tempCaportWidth = carportWidth - 70;

        double hypotenuse = Math.sqrt((tempCaportLength * tempCaportLength) + (tempCaportWidth * tempCaportWidth));

        return hypotenuse;
    }



    public static int calcRoof(int carportLength, int carportWidth, int materialLength){
        double materialWidth = 109.0;

        double devider = (carportLength / materialWidth) - 1;

        if (devider % 1 > 0) {
            devider = devider + 1;
        }

        int tempCarportLength = carportLength + (20*(int) devider);

        double numberOfMaterialPRCarportLength = tempCarportLength / materialWidth;

        if (numberOfMaterialPRCarportLength % 1 > 0) {
            numberOfMaterialPRCarportLength = numberOfMaterialPRCarportLength + 1;
        }

        if(carportWidth > materialLength){

            float widthDevider = ((float)carportWidth / (float)materialLength) - 1;

            if (widthDevider % 1 > 0) {
                widthDevider = widthDevider + 1;
            }

            int tempCarportWidth = carportWidth + (20*(int) widthDevider);

            int numberOfMaterialPRCarportWidth = (tempCarportWidth / materialLength) + 1;

            return numberOfMaterialPRCarportWidth * (int)numberOfMaterialPRCarportLength;
        }

        return (int)numberOfMaterialPRCarportLength;


    }

    public static int calcRoofScrews(int carportLength, int carportWidth){
        return ((carportLength  / 100 ) * (carportWidth  / 100)) * 12;
    }



}
