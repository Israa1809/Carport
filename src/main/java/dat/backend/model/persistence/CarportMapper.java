package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Customer;
import dat.backend.model.persistence.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarportMapper {


    public static int addCarport(Carport carport, int customerId, ConnectionPool connectionPool) {

        String sql = "INSERT INTO carport.carport (length, width, material_full_price, fee_price, customer_id) VALUES (?,?,?,?,?)";
        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            ps.setInt(1, carport.getLength());
            ps.setInt(2, carport.getWidth());
            ps.setFloat(3, carport.getMaterialFullPrice());
            ps.setFloat(4, carport.getFeePrice());
            ps.setInt(5, customerId);

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public static Carport getCarportById(int carportId, ConnectionPool connectionPool) {

        String sql = "SELECT * FROM carport.carport WHERE carport_id = ?";

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carportId);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    float material_full_price = rs.getFloat("material_full_price");
                    float fee_price = rs.getFloat("fee_price");

                    Carport carport = new Carport(length, width);
                    carport.setMaterialFullPrice(material_full_price);
                    carport.setFeePrice(fee_price);

                    return carport;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Carport> getCarportList(ConnectionPool connectionPool) {
        String sql = "SELECT * FROM carport.carport";
        ArrayList<Carport> carports = new ArrayList<>();

        try (Connection connection = connectionPool.getConnection()) {

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {

                    int id = rs.getInt("carport_id");
                    int length = rs.getInt("length");
                    int width = rs.getInt("width");
                    float material_full_price = rs.getFloat("material_full_price");
                    float fee_price = rs.getFloat("fee_price");

                    Carport carport = new Carport(length, width);
                    carport.setMaterialFullPrice(material_full_price);
                    carport.setFeePrice(fee_price);
                    carport.setCarportId(id);
                    carports.add(carport);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carports;
    }
}
