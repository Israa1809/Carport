package dat.backend.model.services;

public class SVG {


    private int x;
    private int y;
    private int height;
    private int width;
    private String viewbox;
    private StringBuilder svgString = new StringBuilder();

    private final static String HEADERTEMPLATE =
            "<svg x=\"%d\" y=\"%d\" height=\"%d%%\" width=\"%d%%\" viewBox=\"%s\" preserveAspectRatio=\"xMinYMin\">";
    private final static String RECTTEMPLATE =
            "<rect x=\"%d\" y=\"%d\" height=\"%f\" width=\"%f\" style=\"stroke:#000000; fill: #ffffff\" />";
    private final static String ARROWHEADSTEMPLATE = "<defs>\n" +
            "        <marker id=\"beginArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"0\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,6 L12,0 L12,12 L0,6\" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "        <marker id=\"endArrow\" markerWidth=\"12\" markerHeight=\"12\" refX=\"12\" refY=\"6\" orient=\"auto\">\n" +
            "            <path d=\"M0,0 L12,6 L0,12 L0,0 \" style=\"fill: #000000;\" />\n" +
            "        </marker>\n" +
            "    </defs>";

    private final static String DASHEDLINETEMPLATE = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; stroke-dasharray: 5 5;\"/>";

    private final static String LINETEMPLATE = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000;\"/>";

    private final static String ARROWLINETEMPLATE = "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:#000000; marker-start: url(#beginArrow); marker-end: url(#endArrow); \"/>";

    private final static String TEXTTEMPLATE = "<text style=\"text-anchor: middle\" transform=\"translate(%d,%d) %s\">%d%s</text>";


    public SVG(int x, int y, int height, int width, String viewbox)
    {
        svgString.append(String.format(HEADERTEMPLATE, x, y, height, width, viewbox));
        svgString.append(ARROWHEADSTEMPLATE);
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.viewbox = viewbox;
    }

    public void addRect(int x, int y, double height, double width)
    {
        svgString.append(String.format(RECTTEMPLATE, x, y, height, width));
    }

    public void addDashedLine(double x1, double y1, double x2, double y2){
        svgString.append(String.format(DASHEDLINETEMPLATE, x1, y1, x2, y2));
    }

    public void addLine(double x1, double y1, double x2, double y2){
        svgString.append(String.format(LINETEMPLATE, x1, y1, x2, y2));
    }

    public void addInnerSvg(SVG innerSVGDrawing)
    {
        svgString.append(innerSVGDrawing);
    }


    public void addArrowLine(double x1, double y1, double x2, double y2){
        svgString.append(String.format(ARROWLINETEMPLATE, x1, y1, x2, y2));
    }

    public void addText(int x1, int y1,String rotate, int value, String unit){
        svgString.append(String.format(TEXTTEMPLATE, x1, y1, rotate, value, unit));
    }

    @Override
    public String toString()
    {
        return svgString + "</svg>";
    }
}
