package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "TogglePayment", value = "/togglepayment")
public class TogglePayment extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int carport_id = Integer.parseInt(request.getParameter("carportId"));
        CarportFacade.togglePayment(carport_id, connectionPool);

        Carport carport = CarportFacade.getCarportById(carport_id,connectionPool);

        int length = carport.getLength();
        int width = carport.getWidth();
        if(carport.getHasShed()) {
            SVG svgCarportTopViewWithShed = CarportSVG.drawCarportTopViewWithShed(length, width);
            SVG svgCarportSideViewWithShed = CarportSVG.drawCarportSideViewWithShed(length, width);
            request.setAttribute("svgCarportTopViewWithShed", svgCarportTopViewWithShed);
            request.setAttribute("svgCarportSideViewWithShed", svgCarportSideViewWithShed);

        } else {
            SVG svgCarportTopView = CarportSVG.drawCarportTopView(length, width);
            SVG svgCarportSideView = CarportSVG.drawCarportSideView(length, width);
            request.setAttribute("svgCarportTopView", svgCarportTopView);
            request.setAttribute("svgCarportSideView", svgCarportSideView);
        }

        request.getRequestDispatcher("WEB-INF/stykliste.jsp").forward(request, response);

    }
}
