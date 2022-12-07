package dat.backend.model.entities;

public class Material {

    private int materialQuantity;
    private String materialName;
    private String unitType;
    private double materialPrice;
    private int materialId;

    private String productVariant;

    public Material(int materialQuantity, String materialName, String unitType, double materialPrice, String productVariant ) {
        this.materialQuantity = materialQuantity;
        this.materialName = materialName;
        this.unitType = unitType;
        this.materialPrice = materialPrice;
        this.productVariant = productVariant;
        this.materialId = materialId;
    }

    public int getMaterialQuantity() {
        return materialQuantity;
    }

    public String getMaterialName() {
        return materialName;
    }

    public String getUnitType() {
        return unitType;
    }

    public double getMaterialPrice() {
        return materialPrice;
    }

    public String getProductVariant() {
        return productVariant;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getMaterialId() {
        return materialId;
    }
}
