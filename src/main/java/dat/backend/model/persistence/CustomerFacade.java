package dat.backend.model.persistence;

import dat.backend.model.entities.Customer;
import dat.backend.model.entities.Material;

import java.util.ArrayList;

public class CustomerFacade {

    public static int addCustomer(Customer customer, ConnectionPool connectionPool){
        return CustomerMapper.addCustomer(customer, connectionPool);
    }
}
