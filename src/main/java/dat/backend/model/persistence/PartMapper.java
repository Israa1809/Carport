package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Part;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class PartMapper {
    public static void addParts(Carport carport, ConnectionPool connectionPool) {
        String sql = "INSERT INTO carport.part (part_quantity, carport_id, part_price, material_id) VALUES (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            for (Part part: carport.getPartList()) {
                ps.setInt(1, part.getPartQuantity());
                ps.setInt(2, carport.getCarportId());
                ps.setFloat(3, part.getPartPrice());
                ps.setInt(4, part.getMaterial().getMaterialId());
                ps.executeUpdate();


            }







        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    }

