package dat.backend.model.entities;

public class Material {

    private int materialQuantity;
    private String materialName;
    private String unitType;
    private float materialPrice;
    private int materialId;

    private String productVariant;

    public Material(int materialQuantity, String materialName, String unitType, float materialPrice, String productVariant ) {
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

    public float getMaterialPrice() {
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

    public void setMaterialQuantity(int materialQuantity) {
        this.materialQuantity = materialQuantity;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public void setMaterialPrice(float materialPrice) {
        this.materialPrice = materialPrice;
    }

    public void setProductVariant(String productVariant) {
        this.productVariant = productVariant;
    }
}
