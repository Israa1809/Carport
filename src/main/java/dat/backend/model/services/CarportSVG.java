package dat.backend.model.services;

public class CarportSVG {

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    public static SVG addBeams(SVG svg, int length) {
        for (int i = 0; i < length; i += 55) {
            svg.addRect(i, 0, 600.0, 4.5);
        }
        svg.addRect(100, 35, 8, 8);
        return svg;
    }

    public static SVG addPoles(SVG svg, int length) {
        for (int i = 100; i < length; i += 310) {

            svg.addRect(i, 35, 9, 9);
        }

        return svg;
    }

    public static SVG addWallPlate(SVG svg, int length) {

        for (int i = 35; i < length; i += 530) {
            svg.addRect(0, i, 5, length);
        }

        return svg;
    }



}
