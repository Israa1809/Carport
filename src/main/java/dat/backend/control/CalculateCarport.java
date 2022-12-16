package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.services.BillOfMaterials;
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

        Carport carport = BillOfMaterials.buildCarport(new Carport(length, width), materialArrayList);
        session.setAttribute("carport", carport);


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        StringBuilder viewbox = new StringBuilder();
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(0);
        viewbox.append(" ");
        viewbox.append(length+100);
        viewbox.append(" ");
        viewbox.append(width+100);

        SVG svgCarport = CarportSVG.createNewSVG(0, 0, 100, 60, viewbox.toString());
        svgCarport = CarportSVG.addFascia(svgCarport, length, width);
        svgCarport = CarportSVG.addBeams(svgCarport, length, width);
        svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
        svgCarport = CarportSVG.addPerforatedTape(svgCarport, length, width);
        svgCarport = CarportSVG.addPoles(svgCarport, length, width);
        request.setAttribute("svgCarport", svgCarport);

        SVG svgCarportSide = CarportSVG.createNewSVG(0,0,100,60,viewbox.toString());
        svgCarportSide = CarportSVG.addPolesSide(svgCarportSide,length);
        svgCarportSide = CarportSVG.addRoofSide(svgCarportSide,length,width);
        request.setAttribute("svgCarportSide", svgCarportSide);


        request.getRequestDispatcher("skitseside.jsp").forward(request, response);
    }

}