package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "ToOrderView", value = "/toorderview")
public class ToOrderView extends HttpServlet {
    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        User user =(User)request.getAttribute("user");
        Carport carport = CarportFacade.getCarportById(Integer.parseInt(user.getUsername()),connectionPool);

        int length = carport.getLength();
        int width = carport.getWidth();

        SVG svgCarport = CarportSVG.createNewSVG(0, 0, 100, 60, "0 0 1600 1300");
        svgCarport = CarportSVG.addFascia(svgCarport, length, width);
        svgCarport = CarportSVG.addBeams(svgCarport, length, width);
        svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
        svgCarport = CarportSVG.addPerforatedTape(svgCarport, length, width);
        svgCarport = CarportSVG.addPoles(svgCarport, length, width);
        request.setAttribute("svgCarport", svgCarport);


        request.getRequestDispatcher("WEB-INF/ordrevisning.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
