package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(name = "ToggleOffer", value = "/toggleoffer")
public class ToggleOffer extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int carport_id = Integer.parseInt(request.getParameter("carportId"));
        CarportFacade.toggleOffer(carport_id, connectionPool);
        ArrayList<Carport> carportList = CarportFacade.getCarportList(connectionPool);
        session.setAttribute("carportList", carportList);

        request.getRequestDispatcher("WEB-INF/kundeordrer.jsp").forward(request, response);

    }
}
