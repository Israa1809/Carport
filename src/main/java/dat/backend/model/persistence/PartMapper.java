package dat.backend.model.persistence;

import dat.backend.model.entities.Carport;
import dat.backend.model.entities.Material;
import dat.backend.model.entities.Part;

import java.sql.*;

public class PartMapper {


    public static void addParts(Carport carport, ConnectionPool connectionPool) {
        String sql = "INSERT INTO carport.part (part_quantity, carport_id, part_price, material_id) VALUES (?,?,?,?)";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            for (Part part : carport.getPartList()) {
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


    protected static void getPartListbyCarportId(Carport carport, ConnectionPool connectionPool) {

        String sql = "SELECT part_quantity, material_quantity, material_name, unit_type, material_price, product_variant, part_price FROM material\n" +
                "INNER JOIN part p on material.material_id = p.material_id\n" +
                "WHERE carport_id = ?;";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, carport.getCarportId());
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int partQuantity = rs.getInt("part_quantity");
                    int material_quantity = rs.getInt("material_quantity");
                    String materialName = rs.getString("material_name");
                    String unitType = rs.getString("unit_type");
                    float materialPrice = rs.getFloat("material_price");
                    String productVariant = rs.getString("product_variant");
                    float partPrice = rs.getFloat("part_price");

                    Material material = new Material(material_quantity, materialName, unitType, materialPrice, productVariant);
                    Part part = new Part(material, partQuantity, partPrice);
                    carport.setPartListFromDB(part);
                }

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}

