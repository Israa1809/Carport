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
}
