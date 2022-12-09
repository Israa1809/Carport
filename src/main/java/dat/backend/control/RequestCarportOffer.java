package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Customer;
import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CustomerFacade;
import dat.backend.model.persistence.UserFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RequestCarportOffer", urlPatterns = {"/requestcarportoffer"})
public class RequestCarportOffer extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();

        String name = request.getParameter("name");
        String address = request.getParameter("address");
        int zipcode = Integer.parseInt(request.getParameter("zipcode"));
        String city = request.getParameter("city");
        int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
        String email = request.getParameter("email");

        Customer customer = new Customer(name, address, zipcode, city, phonenumber, email);

        int customerId = CustomerFacade.addCustomer(customer, connectionPool);

        Carport carport = (Carport) session.getAttribute("carport");

        int carportId = CarportFacade.addCarport(carport, customerId, connectionPool);

        request.setAttribute("carportId", carportId);

        try {
            User user = new User(String.valueOf(carportId), String.valueOf(customer.getPhoneNumber()), "user");

            UserFacade.createUser(user.getUsername(), user.getPassword(), user.getRole(), connectionPool);
            customer.setUser(user);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("bekræftelsesside.jsp").forward(request, response);
    }

}