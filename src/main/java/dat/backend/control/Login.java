package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.*;
import dat.backend.model.exceptions.DatabaseException;
import dat.backend.model.persistence.*;
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
import java.util.List;
import java.util.Locale;

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

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        Locale.setDefault(new Locale("US"));

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

            int length = carport.getLength();
            int width = carport.getWidth();

            StringBuilder viewbox = new StringBuilder();
            viewbox.append(0);
            viewbox.append(" ");
            viewbox.append(0);
            viewbox.append(" ");
            viewbox.append(length+150);
            viewbox.append(" ");
            viewbox.append(width+150);

            SVG svgCarport = CarportSVG.createNewSVG(120, 50, 100, 100, viewbox.toString());
            svgCarport = CarportSVG.addFascia(svgCarport, length, width);
            svgCarport = CarportSVG.addBeams(svgCarport, length, width);
            svgCarport = CarportSVG.addWallPlate(svgCarport, length, width);
            svgCarport = CarportSVG.addPerforatedTape(svgCarport, length, width);
            svgCarport = CarportSVG.addPoles(svgCarport, length, width);

            SVG svgWithArrows = CarportSVG.createNewSVG( 0, 0, 100, 60, viewbox.toString());
            svgWithArrows.addInnerSvg(svgCarport);
            svgWithArrows = CarportSVG.addArrow(svgWithArrows, length, width);

            request.setAttribute("svgCarportTopView", svgWithArrows);

            StringBuilder sideViewbox = new StringBuilder();
            sideViewbox.append(0);
            sideViewbox.append(" ");
            sideViewbox.append(0);
            sideViewbox.append(" ");
            sideViewbox.append(length+150);
            sideViewbox.append(" ");
            sideViewbox.append(380);

            SVG svgCarportSide = CarportSVG.createNewSVG(120,50,100,100, sideViewbox.toString());
            svgCarportSide = CarportSVG.addPolesSide(svgCarportSide,length);
            svgCarportSide = CarportSVG.addRoofSide(svgCarportSide,length,width);

            SVG svgCarportSideArrows = CarportSVG.createNewSVG(0,0,100,60, sideViewbox.toString());
            svgCarportSideArrows.addInnerSvg(svgCarportSide);
            svgCarportSideArrows = CarportSVG.addArrowSide(svgCarportSideArrows, length, width);
            request.setAttribute("svgCarportSideView", svgCarportSideArrows);

//            float totalCarportPrice = carport.getMaterialFullPrice()+carport.getFeePrice();
//            session.setAttribute("totalCarportPrice", totalCarportPrice);

            PartFacade.getPartListbyCarportId(carport, connectionPool);
            session.setAttribute("partList", carport.getPartList());
            session.setAttribute("carport", carport);

            request.getRequestDispatcher("WEB-INF/ordrevisning.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

}