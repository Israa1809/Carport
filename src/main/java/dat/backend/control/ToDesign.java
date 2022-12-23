package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Customer;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.CustomerFacade;
import dat.backend.model.persistence.PartFacade;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "ToDesign", urlPatterns = {"/todesign"} )
public class ToDesign extends HttpServlet
{

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport = CarportFacade.getCarportById(carportId, connectionPool);
        PartFacade.getPartListbyCarportId(carport, connectionPool);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

        int length = carport.getLength();
        int width = carport.getWidth();

        if(carport.getHasShed()) {
            SVG svgCarportTopViewWithShed = CarportSVG.drawCarportTopViewWithShed(length, width);
            SVG svgCarportSideViewWithShed = CarportSVG.drawCarportSideViewWithShed(length, width);
            request.setAttribute("svgCarportTopViewWithShed", svgCarportTopViewWithShed);
            request.setAttribute("svgCarportSideViewWithShed", svgCarportSideViewWithShed);

        } else {
            SVG svgCarportTopView = CarportSVG.drawCarportTopView(length, width);
            SVG svgCarportSideView = CarportSVG.drawCarportSideView(length, width);
            request.setAttribute("svgCarportTopView", svgCarportTopView);
            request.setAttribute("svgCarportSideView", svgCarportSideView);
        }
        request.setAttribute("partlist", carport.getPartList());
        request.setAttribute("carport", carport);

        Customer customer = CustomerFacade.getCustomerById(carportId, connectionPool);
        request.setAttribute("customer", customer);

        request.getRequestDispatcher("WEB-INF/ordredesign.jsp").forward(request, response);
    }

}