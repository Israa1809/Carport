package dat.backend.model.entities;

public class Part {
    private Material material;
    private int partQuantity;
    private float partPrice;

    public Part(Material material, int partQuantity) {
        this.material = material;
        this.partQuantity = partQuantity;
        setPartPrice(partQuantity, material.getMaterialPrice());
    }

    public float setPartPrice(int partQuantity, float materialPrice){
        partPrice = partQuantity * materialPrice;
        return partPrice;
    }

    public float getPartPrice() {
        return partPrice;
    }

}
