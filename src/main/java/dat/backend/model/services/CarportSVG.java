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
        int height = 210;

        if(length == 470) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, height, 5);
                y += 10;
                height -= 10;
            }
        }
        //3 poles sættes
        if(length > 470 && length <= 780) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, height, 5);
                y += 5;
                height -= 5;
            }
        }
        //4 poles sættes
        if(length > 780 && length <= 1090) {
            for (int i = 100; i < length; i += 310) {
                svg.addRect(i, y, height, 5);
                y += 3;
                height -= 3;
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
        //Lodrette Pile
        svg.addArrowLine(55, 50, 55, width + 50);
        svg.addArrowLine(100, 85, 100, width + 15);
        svg.addText(45, (width / 2) + 50, "rotate(-90)", width, "cm");
        svg.addText(90, (width / 2) + 50, "rotate(-90)", width - 70, "cm");

        //vandrette Pile
        svg.addArrowLine(120, width + 120, length + 120, width + 120);
        svg.addText((length / 2) + 110, width + 110, "", length, "cm");


        if(length == 470) {
            for (int i = 120; i < length + 55; i += 55) {
                svg.addArrowLine(i, 30, i + 55, 30);
                for (int j = 147; j < length + 110; j += 55) {
                    svg.addText(j, 20, "", 55, "");
                }
            }
        }

        if(length > 470 && length <= 1090) {
            for (int i = 120; i < length + 110; i += 55) {
                svg.addArrowLine(i, 30, i + 55, 30);
                for (int j = 147; j < length + 110; j += 55) {
                    svg.addText(j, 20, "", 55, "");
                }
            }
        }
        return svg;
    }

    public static SVG addArrowSide(SVG svg, int length, int width) {
        //Lodrette Pile
        svg.addArrowLine(55, 50, 55, 280);
        svg.addText(45, 165, "rotate(-90)", 230, "cm");
        svg.addArrowLine(100, 70, 100, 280);
        svg.addText(90, 165, "rotate(-90)", 210, "cm");
        svg.addArrowLine(length + 130, 60, length + 130, 280);
        svg.addText(length + 150, 165, "rotate(-90)", 220, "cm");
        svg.addLine(55, 280, length + 130, 280);

        //vandrette Pile
        svg.addArrowLine(120, 230 + 90, length + 120, 230 + 90);
        svg.addText((length / 2) + 110, 230 + 80, "", length, "cm");

        return svg;
    }

    public static SVG addShed(SVG svg, int length, int width) {
        //vandrette
        svg.addRect(length - 230, 35, width - 70, 10);
        svg.addRect(length - 20, 35, width - 70, 10);
        //lodrette
        svg.addRect(length - 230, 30, 10, length - (length - 220));
        svg.addRect(length - 230, width - 40, 10, length - (length - 220));
        //skur stolper


        //1 skur pæle
        if(width > 300 && width <= 600) {
            for (int i = 30; i < width; i += 265) {
                svg.addRect(length - 230, i, 10, 10);
                svg.addRect(length - 20, i, 10, 10);
            }
        }
        //3 skur pæle
        if(width > 600 && width <= 900) {
            for (int i = 30; i < width; i += 207.5) {
                svg.addRect(length - 230, i, 10, 10);
                svg.addRect(length - 20, i, 10, 10);
            }
        }

        if(width > 900 && width <= 1200) {
            for (int i = 30; i < width; i += 226) {
                svg.addRect(length - 230, i, 10, 10);
                svg.addRect(length - 20, i, 10, 10);
            }
        }
        return svg;
    }

    public static SVG addShedSide(SVG svg, int length, int width) {
        svg.addRect(length - 230, 20, 210, length - (length - 210));

        for (int i = length - 230; i < length - 50; i += 24) {
            svg.addRect(i, 20, 210, 20);
            svg.addRect(i + 20, 20, 210, 7);

        }
        return svg;
    }

    //Hulbånd
    public static SVG addPerforatedTapeShed(SVG svg, int length, int width) {
        int x = 100;
        int y = 35;

        svg.addDashedLine(x, y, length-230, width-y);
        svg.addDashedLine(x, width-y, length-230, y);

        return svg;
    }

    public static SVG drawCarportTopView(int length, int width) {
        StringBuilder viewbox = new StringBuilder();
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(length + 150);
        viewbox.append(" ");
        viewbox.append(width + 150);

        SVG svgCarport = CarportSVG.createNewSVG(120, 50, 100, 100, viewbox.toString());
        svgCarport = CarportSVG.addFascia(svgCarport, length, width);
        svgCarport = CarportSVG.addBeams(svgCarport, length, width);
        svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
        svgCarport = CarportSVG.addPerforatedTape(svgCarport, length, width);
        svgCarport = CarportSVG.addPoles(svgCarport, length, width);

        SVG svgWithArrows = CarportSVG.createNewSVG(0, 0, 100, 60, viewbox.toString());
        svgWithArrows.addInnerSvg(svgCarport);
        svgWithArrows = CarportSVG.addArrow(svgWithArrows, length, width);

        return svgWithArrows;
    }

    public static SVG drawCarportTopViewWithShed(int length, int width) {
        StringBuilder viewbox = new StringBuilder();
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(length + 150);
        viewbox.append(" ");
        viewbox.append(width + 150);


        SVG svgShed = CarportSVG.createNewSVG(0, 0, 100, 100, viewbox.toString());
        svgShed = CarportSVG.addShed(svgShed, length, width);


        SVG svgCarport = CarportSVG.createNewSVG(120, 50, 100, 100, viewbox.toString());
        svgCarport = CarportSVG.addFascia(svgCarport, length, width);
        svgCarport = CarportSVG.addBeams(svgCarport, length, width);
        svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
        svgCarport = CarportSVG.addPerforatedTapeShed(svgCarport, length, width);
        svgCarport.addInnerSvg(svgShed);
        svgCarport = CarportSVG.addPoles(svgCarport, length, width);

        SVG svgWithArrows = CarportSVG.createNewSVG(0, 0, 100, 60, viewbox.toString());
        svgWithArrows.addInnerSvg(svgCarport);
        svgWithArrows = CarportSVG.addArrow(svgWithArrows, length, width);


        return svgWithArrows;
    }

    public static SVG drawCarportSideView(int length, int width) {
        StringBuilder sideViewbox = new StringBuilder();
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(length + 150);
        sideViewbox.append(" ");
        sideViewbox.append(380);

        SVG svgCarportSide = CarportSVG.createNewSVG(120, 50, 100, 100, sideViewbox.toString());
        svgCarportSide = CarportSVG.addPolesSide(svgCarportSide, length);
        svgCarportSide = CarportSVG.addRoofSide(svgCarportSide, length, width);

        SVG svgCarportSideArrows = CarportSVG.createNewSVG(0, 0, 100, 60, sideViewbox.toString());
        svgCarportSideArrows.addInnerSvg(svgCarportSide);
        svgCarportSideArrows = CarportSVG.addArrowSide(svgCarportSideArrows, length, width);

        return svgCarportSideArrows;
    }

    public static SVG drawCarportSideViewWithShed(int length, int width) {
        StringBuilder sideViewbox = new StringBuilder();
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(length + 150);
        sideViewbox.append(" ");
        sideViewbox.append(380);

        SVG svgShedSideView = CarportSVG.createNewSVG(0, 0, 100, 100, sideViewbox.toString());
        svgShedSideView = CarportSVG.addShedSide(svgShedSideView, length, width);

        SVG svgCarportSide = CarportSVG.createNewSVG(120, 50, 100, 100, sideViewbox.toString());
        svgCarportSide = CarportSVG.addPolesSide(svgCarportSide, length);
        svgCarportSide.addInnerSvg(svgShedSideView);
        svgCarportSide = CarportSVG.addRoofSide(svgCarportSide, length, width);

        SVG svgCarportSideArrows = CarportSVG.createNewSVG(0, 0, 100, 60, sideViewbox.toString());
        svgCarportSideArrows.addInnerSvg(svgCarportSide);
        svgCarportSideArrows = CarportSVG.addArrowSide(svgCarportSideArrows, length, width);

        return svgCarportSideArrows;
    }
}





