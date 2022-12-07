package dat.backend.model.persistence;

import dat.backend.model.config.ApplicationStart;
import dat.backend.model.entities.Material;

import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MaterialMapper {


    protected static ArrayList<Material> getMaterials(ConnectionPool connectionPool) {

        ArrayList<Material> materialArrayList = new ArrayList<>();

        String sql = "SELECT * FROM carport.material";

        try (Connection connection = connectionPool.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    int materialId = rs.getInt("material_id");
                    int materialQuantity = rs.getInt("material_quantity");
                    String materialName = rs.getString("material_name");
                    String unitType = rs.getString("unit_type");
                    double materialPrice = rs.getDouble("material_price");
                    String productVariant = rs.getString("product_variant");

                    Material material = new Material(materialQuantity, materialName, unitType, materialPrice, productVariant);
                    material.setMaterialId(materialId);
                    materialArrayList.add(material);
                }


            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return materialArrayList;
    }


    protected static void deleteMaterialById(int materialId, ConnectionPool connectionPool) {

            String sql = "DELETE FROM carport.material where material_id = ?";

            try (Connection connection = connectionPool.getConnection();
                 PreparedStatement ps = connection.prepareStatement(sql)) {

                ps.setInt(1, materialId );
                ps.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

    }
}
