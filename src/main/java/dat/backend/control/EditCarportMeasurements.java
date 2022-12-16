package dat.backend.control;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.services.BillOfMaterials;
import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.persistence.CarportFacade;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.MaterialFacade;
import dat.backend.model.persistence.PartFacade;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "EditCarportMeasurements", value = "/editcarportmeasurements")
public class EditCarportMeasurements extends HttpServlet {

    private ConnectionPool connectionPool = ApplicationStart.getConnectionPool();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int carportId = Integer.parseInt(request.getParameter("carportId"));
        Carport carport = CarportFacade.getCarportById(carportId, connectionPool);

        HttpSession session = request.getSession();
        int length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));

        ArrayList<Material> materialArrayList = MaterialFacade.getMaterials(connectionPool);
        session.setAttribute("materialArrayList", materialArrayList);

        Carport editedCarport = BillOfMaterials.buildCarport(new Carport(length, width), materialArrayList);
        editedCarport.setCarportId(carport.getCarportId());
        PartFacade.deletePartListByCarportID(carport.getCarportId(), connectionPool);

        carport.setPartList(editedCarport.getPartList());
        PartFacade.updatePartList(carport, connectionPool);
        CarportFacade.updateCarportInfo(editedCarport, connectionPool);

        carport = CarportFacade.getCarportById(carportId, connectionPool);

        PartFacade.getPartListbyCarportId(carport, connectionPool);
        request.setAttribute("partList", carport.getPartList());

        request.setAttribute("carport", carport);

        request.getRequestDispatcher("WEB-INF/redigercarport.jsp").forward(request, response);

    }
}
