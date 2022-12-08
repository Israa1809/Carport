package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.persistence.ConnectionPool;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToDesign", urlPatterns = {"/todesign"} )
public class ToDesign extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

        request.getRequestDispatcher("WEB-INF/ordredesign.jsp").forward(request, response);



    }

}