package dat.backend.model.services;

public class Calculator {

    public static int calcPoles(int carportLength, int carportWidth) {     //'poles' er 'stolper' på dansk

        float lengthInterval = 310f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis længden overstiger 310 cm skal der indsættes en ekstra stolpe
        float widthInterval = 530f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis bredden overstiger 530 cm skal der indsættes en ekstra stolpe
        int lengthStandOff = 160;
        int widthStandOff = 70;
        int resLength;
        int resWidth;

        float lengthDiv = (carportLength-lengthStandOff)/lengthInterval;
        float widthDiv = (carportWidth-widthStandOff)/widthInterval;

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
        return ((fasciaLength/100)+1)*2;    //400cm / 100 = 4 + 1 = 5 * 2 = 10
    } //Vi har vedtaget at der ved over- og understern bruges 2 skruer per meter
}
