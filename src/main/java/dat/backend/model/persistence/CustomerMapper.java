package dat.backend.model.persistence;

import com.mysql.cj.protocol.Resultset;
import dat.backend.model.entities.Customer;

import java.sql.*;

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

    public static Customer getCustomerById(int customerId, ConnectionPool connectionPool) {
        String sql = "SELECT * from customer inner join carport c on customer.customer_id = c.customer_id where c.carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, customerId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String customerName = rs.getString("customer_name");
                    String adress = rs.getString("address");
                    int postalCode = rs.getInt("postal_code");
                    String city = rs.getString("city");
                    int phoneNumber = rs.getInt("phone_number");
                    String email = rs.getString("email");

                    Customer customer = new Customer(customerName, adress, postalCode, city, phoneNumber, email);
                    return customer;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
