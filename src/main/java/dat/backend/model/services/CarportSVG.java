package dat.backend.model.services;

public class CarportSVG {

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }
    //Spær
    public static SVG addBeams(SVG svg, int length,int width) {
        for (int i = 0; i < length; i += 55) {
            svg.addRect(i, 0, width, 4.5);
        }
        return svg;
    }
    //Stolper
    public static SVG addPoles(SVG svg, int length, int width) {
        for (int i = 100; i < length; i += 310) {
        svg.addRect(i, 35-5, 10, 10);
        svg.addRect(i, width-35-5, 10, 10);
            if(width > 600){
                svg.addRect(i, (width/2)-5, 10, 10);
            }


        }

        return svg;
    }
    //Stern
    public static SVG addFascia(SVG svg, int length, int width) {

        svg.addRect(0,0,width, length);

        return svg;
    }
    //Rem
    public static SVG addWallPlate(SVG svg, int length, int width) {
        svg.addRect(0, 35, 5, length);
        svg.addRect(0, width-40, 5, length);
        if(width > 600){
            svg.addRect(0, (width/2)-(5/2), 5, length);
        }
//        for (int i = 35; i < length; i += 530) {
//            svg.addRect(0, i, 5, length);
       //}

        return svg;
    }
    //Hulbånd
    public static SVG addPerforatedTape(SVG svg, int length, int width){
        int x = 0;
        int y = 0;

        for (int i = 100; i < length; i += 310) {
            x = i;
        }
        for (int j = 35; j < width; j +=530) {
            y = j;
        }
        svg.addLine(100,35,x,y);
        svg.addLine(100, y, x,35);
        return svg;
    }



}
