package dat.backend.model.persistence;

import com.mysql.cj.protocol.Resultset;
import dat.backend.model.entities.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CustomerMapper {
    public static int addCustomer(Customer customer, ConnectionPool connectionPool) {
        String sql = "INSERT INTO carport.customer (customer_name, address, postal_code, city, phone_number, email) VALUES (?,?,?,?,?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, customer.getCustomerName());
            ps.setString(2, customer.getAddress());
            ps.setInt(3, customer.getPostalCode());
            ps.setString(4, customer.getCity());
            ps.setInt(5, customer.getPhoneNumber());
            ps.setString(6, customer.getEmail());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);




        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
