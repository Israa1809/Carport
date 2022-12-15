package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.User;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.persistence.PartFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ToEditCarport", urlPatterns = {"/toeditcarport"} )
public class ToEditCarport extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.getRequestDispatcher("WEB-INF/ordredesign.jsp").forward(request, response);


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport = CarportFacade.getCarportById(carportId, connectionPool);
        request.setAttribute("carport", carport);

        request.getRequestDispatcher("WEB-INF/redigercarport.jsp").forward(request, response);

    }

}