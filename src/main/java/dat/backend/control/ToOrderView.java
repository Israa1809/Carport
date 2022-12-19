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
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        User user = (User) session.getAttribute("user");
        Carport carport = CarportFacade.getCarportById(Integer.parseInt(user.getUsername()), connectionPool);

        int length = carport.getLength();
        int width = carport.getWidth();

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

        request.setAttribute("svgCarportTopView", svgWithArrows);

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
        request.setAttribute("svgCarportSideView", svgCarportSideArrows);

        request.getRequestDispatcher("WEB-INF/ordrevisning.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
