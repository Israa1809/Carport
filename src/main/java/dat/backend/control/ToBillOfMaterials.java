package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Part;
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

@WebServlet(name = "ToBillOfMaterials", urlPatterns = {"/tobillofmaterials"} )
public class ToBillOfMaterials extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        Carport carport = (Carport) session.getAttribute("carport");
        session.setAttribute("carport", carport);
        request.getRequestDispatcher("WEB-INF/stykliste.jsp").forward(request, response);
    }

}