package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.services.CarportBuilder;
import dat.backend.model.services.CarportSVG;
import dat.backend.model.services.SVG;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@WebServlet(name = "CalculateCarport", urlPatterns = {"/calculatecarport"})
public class CalculateCarport extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.sendRedirect("index.jsp");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();

        try {
            if(request.getParameter("length") != null || request.getParameter("width") != null) {

                int length = Integer.parseInt(request.getParameter("length"));
                int width = Integer.parseInt(request.getParameter("width"));

                ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);

                Carport carport = CarportBuilder.buildCarport(new Carport(length, width), materialArrayList);
                session.setAttribute("carport", carport);

                request.setCharacterEncoding("UTF-8");
                response.setCharacterEncoding("UTF-8");
                Locale.setDefault(new Locale("US"));


                String checkbox = request.getParameter("checkbox");

                if(checkbox != null) {
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

                request.getRequestDispatcher("skitseside.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            String errormessage = "Husk at vælge både længde og bredde";
            request.setAttribute("errormessage", errormessage);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }


}