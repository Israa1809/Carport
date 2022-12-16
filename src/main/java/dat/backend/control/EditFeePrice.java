package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Carport;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.PartFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Locale;

@WebServlet(name = "EditFeePrice", value = "/editfeeprice")
public class EditFeePrice extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport = CarportFacade.getCarportById(carportId, connectionPool);

        float feePrice = Float.parseFloat(request.getParameter("feePrice"));
        carport.setFeePrice(feePrice);

        CarportFacade.updateCarportInfo(carport, connectionPool);

        PartFacade.getPartListbyCarportId(carport, connectionPool);
        request.setAttribute("partList", carport.getPartList());

        request.setAttribute("carport", carport);

        request.getRequestDispatcher("WEB-INF/redigercarport.jsp").forward(request, response);

    }
}
