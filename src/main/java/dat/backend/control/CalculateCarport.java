package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CalculateCarport", urlPatterns = {"/calculatecarport"})
public class CalculateCarport extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);
        HttpSession session = request.getSession();
        Carport carport = BillOfMaterials.buildCarport(new Carport(780, 600), materialArrayList);
        session.setAttribute("carport", carport);

        request.getRequestDispatcher("skitseside.jsp").forward(request, response);
    }

}