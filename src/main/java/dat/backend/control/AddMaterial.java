package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Material;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AddMaterial", urlPatterns = {"/addmaterial"} )
public class AddMaterial extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String unit = request.getParameter("unit");
        String variant = request.getParameter("variant");
        float price = Float.parseFloat(request.getParameter("price"));

        Material material = new Material(quantity, name, unit, price, variant);
        MaterialFacade.addMaterial(material, connectionPool);

        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);
        session.setAttribute("materialArrayList", materialArrayList);

        request.getRequestDispatcher("WEB-INF/materialevarer.jsp").forward(request, response);

    }

}