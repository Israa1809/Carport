package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "login", urlPatterns = {"/login"} )
public class Login extends HttpServlet
{
    private ConnectionPool connectionPool;

    @Override
    public void init() throws ServletException
    {
        this.connectionPool = ApplicationStart.getConnectionPool();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        // You shouldn't end up here with a GET-request, thus you get sent back to frontpage
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);
        session.setAttribute("materialArrayList", materialArrayList);
        session.setAttribute("user", null); // invalidating user object in session scope
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        try
        {
            User user = UserFacade.login(username, password, connectionPool);

            if(user.getRole().equals("admin")){
                session.setAttribute("user", user);

                ArrayList<Carport> carportList = CarportFacade.getCarportList(connectionPool);
                session.setAttribute("carportList", carportList);

                request.getRequestDispatcher("WEB-INF/kundeordrer.jsp").forward(request, response);
            }

            session.setAttribute("user", user); // adding user object to session scope

            Carport carport = CarportFacade.getCarportById(Integer.parseInt(username),connectionPool);
            session.setAttribute("carportId",   Integer.parseInt(username));

//            float totalCarportPrice = carport.getMaterialFullPrice()+carport.getFeePrice();
//            session.setAttribute("totalCarportPrice", totalCarportPrice);

            session.setAttribute("partList", carport.getPartList());
            session.setAttribute("carport", carport);



            request.getRequestDispatcher("WEB-INF/ordrevisning.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

}