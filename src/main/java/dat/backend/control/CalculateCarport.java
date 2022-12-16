package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.services.CarportBuilder;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "CalculateCarport", urlPatterns = {"/calculatecarport"})
public class CalculateCarport extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);

        Carport carport = CarportBuilder.buildCarport(new Carport(length, width), materialArrayList);
        session.setAttribute("carport", carport);


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        StringBuilder viewbox = new StringBuilder();
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(length+150);
        viewbox.append(" ");
        viewbox.append(width+150);

        SVG svgCarport = CarportSVG.createNewSVG(120, 50, 100, 100, viewbox.toString());
        svgCarport = CarportSVG.addFascia(svgCarport, length, width);
        svgCarport = CarportSVG.addBeams(svgCarport, length, width);
        svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
        svgCarport = CarportSVG.addPerforatedTape(svgCarport, length, width);
        svgCarport = CarportSVG.addPoles(svgCarport, length, width);

        SVG svgWithArrows = CarportSVG.createNewSVG( 0, 0, 100, 60, viewbox.toString());
        svgWithArrows.addInnerSvg(svgCarport);
        svgWithArrows = CarportSVG.addArrow(svgWithArrows, length, width);

        request.setAttribute("svgCarportTopView", svgWithArrows);

        StringBuilder sideViewbox = new StringBuilder();
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(0);
        sideViewbox.append(" ");
        sideViewbox.append(length+150);
        sideViewbox.append(" ");
        sideViewbox.append(380);

        SVG svgCarportSide = CarportSVG.createNewSVG(120,50,100,100, sideViewbox.toString());
        svgCarportSide = CarportSVG.addPolesSide(svgCarportSide,length);
        svgCarportSide = CarportSVG.addRoofSide(svgCarportSide,length,width);

        SVG svgCarportSideArrows = CarportSVG.createNewSVG(0,0,100,60, sideViewbox.toString());
        svgCarportSideArrows.addInnerSvg(svgCarportSide);
        svgCarportSideArrows = CarportSVG.addArrowSide(svgCarportSideArrows, length, width);
        request.setAttribute("svgCarportSideView", svgCarportSideArrows);

        request.getRequestDispatcher("skitseside.jsp").forward(request, response);
    }



}