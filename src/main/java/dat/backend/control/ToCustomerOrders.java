package dat.backend.control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ToCustomerOrders", urlPatterns = {"/tocustomerorder"} )
public class ToCustomerOrders extends HttpServlet
{


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        request.getRequestDispatcher("WEB-INF/kundeordrer.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {


    }

}