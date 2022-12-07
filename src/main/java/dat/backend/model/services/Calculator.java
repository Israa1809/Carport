package dat.backend.model.services;

public class Calculator {

    public static int calcBeams(int length, int width) {     //'beams' er 'stolper' på dansk

//        int resLength = 2;
//        int resWidth = 2;
        int resTotal = 4 ;

        float lengthDiv = (length-160)/310f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis længden overstiger 310 cm skal der indsættes en ekstra stolpe
        float widthDiv = (width-70)/530f; //vi har besluttet at længde og bredde måles i cm, og vi antager at hvis bredden overstiger 530 cm skal der indsættes en ekstra stolpe

       if(lengthDiv > 1 && widthDiv > 1){
           resTotal = ((int) lengthDiv + 1) * ((int) widthDiv + 1);
        }

//        if (widthDiv > 1){
//            resWidth = (int) widthDiv + 2;     // + 1 for at runde op fra det decimaltal man muligvis vil få
//        }

        return resTotal;
    }
}
