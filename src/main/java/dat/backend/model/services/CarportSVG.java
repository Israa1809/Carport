package dat.backend.model.services;

public class CarportSVG {

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG addBeams(SVG svg, int length,int width) {
        for (int i = 0; i < length; i += 55) {
            svg.addRect(i, 0, width, 4.5);
        }
        svg.addRect(100, 35, 8, 8);
        return svg;
    }

    public static SVG addPoles(SVG svg, int length, int width) {
        for (int i = 100; i < length; i += 310) {
            for (int j = 35; j < width; j +=530)
            svg.addRect(i, j, 9, 9);

        }

        return svg;
    }

    public static SVG addFascia(SVG svg, int length, int width) {

        svg.addRect(0,0,width, length);

        return svg;
    }

    public static SVG addWallPlate(SVG svg, int length) {
        int j = 560;
        svg.addRect(0, 35, 5, length);
        for (int i = j; i < length; i += 530) {
            svg.addRect(0, i, 5, length);
        }

        return svg;
    }

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
