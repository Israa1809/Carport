package dat.backend.model.services;

public class CarportSVG {

    public static SVG createNewSVG(int x, int y, int height, int width, String viewbox) {
        return new SVG(x, y, height, width, viewbox);
    }

    //Spær
    public static SVG addBeams(SVG svg, int length, int width) {
        for (int i = 0; i < length; i += 55) {
            svg.addRect(i, 0, width, 4.5);
        }
        return svg;
    }

    //Stolper
    public static SVG addPoles(SVG svg, int length, int width) {
        for (int i = 100; i < length; i += 310) {
            svg.addRect(i, 35 - 5, 10, 10);
            svg.addRect(i, width - 35 - 5, 10, 10);
            if(width > 600) {
                svg.addRect(i, (width / 2) - 5, 10, 10);
                svg.addRect(length - 60, (width / 2) - 5, 10, 10);
            }


//            Udkommenteret kode er start på hvis der vælges ikke "perfekte" længder
//            //2 poles sættes
//            if (length == 470) {
//                svg.addRect(i, 35-5, 10, 10);
//                svg.addRect(i, width-35-5, 10, 10);
//            }
//            //3 poles sættes
//            if(length > 470 && length <= 780){
//                svg.addRect(length-60, 35-5, 10,10);
//                svg.addRect(length-60, width-35-5, 10,10);
//            }
//            //4 poles sættes
//            if(length > 780 && length <= 1090){
//                svg.addRect(length-60, 35-5, 10,10);
//                svg.addRect(length-60, width-35-5, 10,10);
//            }


        }

        return svg;
    }

    //Stern
    public static SVG addFascia(SVG svg, int length, int width) {

        svg.addRect(0, 0, width, length);

        return svg;
    }

    //Rem
    public static SVG addWallPlate(SVG svg, int length, int width) {
        svg.addRect(0, 35, 5, length);
        svg.addRect(0, width - 40, 5, length);
        if(width > 600) {
            svg.addRect(0, (width / 2) - (5 / 2), 5, length);
        }
//        for (int i = 35; i < length; i += 530) {
//            svg.addRect(0, i, 5, length);
        //}

        return svg;
    }

    //Hulbånd
    public static SVG addPerforatedTape(SVG svg, int length, int width) {
        int x = 0;
        int y = 35;

        for (int i = 100; i < length; i += 310) {
            x = i;
        }
        svg.addDashedLine(100, y, x, width - y - 5);
        svg.addDashedLine(100, width - y - 5, x, y);
        return svg;
    }

    public static SVG addPolesSide(SVG svg, int length) {
        int y = 20;

        if(length == 470) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, 210, 5);
                y += 10;
            }
        }
        //3 poles sættes
        if(length > 470 && length <= 780) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, 210, 5);
                y += 5;
            }
        }
        //4 poles sættes
        if(length > 780 && length <= 1090) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, 210, 5);
                y += 3;
            }
        }

        return svg;
    }

    public static SVG addRoofSide(SVG svg, int length, int width) {

        svg.addLine(0, 0, length, 10);
        svg.addLine(0, 10, length, 20);
        svg.addLine(0, 20, length, 30);
        svg.addLine(0, 0, 0, 20);
        svg.addLine(length, 10, length, 30);


        return svg;
    }


    public static SVG addArrow(SVG svg, int length, int width) {
        svg.addArrowLine(55, 50, 55, width+50);
        svg.addArrowLine(120, width + 120, length + 120, width + 120);
        svg.addArrowLine(100, 85, 100, width+15);

        svg.addText(45, (width / 2)+50, "rotate(-90)", width, "cm");
        svg.addText((length / 2)+110, width + 110, "", length, "cm");
        svg.addText(90, (width / 2)+50, "rotate(-90)", width-70, "cm");

        if(length == 470) {
            for (int i = 120; i < length+55; i+=55) {
                svg.addArrowLine(i, 30, i+55 , 30);
                for (int j = 147; j < length+110 ; j+=55 ) {
                    svg.addText(j, 20, "", 55, "");
                }
            }
        }

        if(length > 470 && length <= 1090) {
            for (int i = 120; i < length+110; i+=55) {
                svg.addArrowLine(i, 30, i+55 , 30);
                for (int j = 147; j < length+110 ; j+=55 ) {
                    svg.addText(j, 20, "", 55, "");
                }
            }
        }
        return svg;
    }




}





