package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.PartFacade;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "ToDesign", urlPatterns = {"/todesign"} )
public class ToDesign extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {


        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport = CarportFacade.getCarportById(carportId, connectionPool);
        request.setAttribute("carport", carport);
        PartFacade.getPartListbyCarportId(carport, connectionPool);
        request.setAttribute("partlist", carport.getPartList());




        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));


        int length = carport.getLength();
        int width = carport.getWidth();



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


        request.getRequestDispatcher("WEB-INF/ordredesign.jsp").forward(request, response);



    }

}