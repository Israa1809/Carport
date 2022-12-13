package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;

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

        request.getRequestDispatcher("WEB-INF/kundeorder.jsp").forward(request, response);

    }
}
