package dat.backend.model.entities;

public class Material {

    private int materialQuantity;
    private String materialName;
    private String unitType;
    private float materialPrice;

    private String productVariant;

    public Material(int materialQuantity, String materialName, String unitType, float materialPrice, String productVariant ) {
        this.materialQuantity = materialQuantity;
        this.materialName = materialName;
        this.unitType = unitType;
        this.materialPrice = materialPrice;
        this.productVariant = productVariant;
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
}
