package dat.backend.model.entities;

import java.util.List;

public class Carport {

    private int length;
    private int width;
    private int height;
    private float materialFullPrice;
    private float feePrice;
    private List<Part> partList;

    public Carport(int length, int width, int height, float materialFullPrice, float feePrice, List<Part> partList) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.materialFullPrice = materialFullPrice;
        this.feePrice = feePrice;
        this.partList = partList;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getMaterialFullPrice() {
        return materialFullPrice;
    }

    public float getFeePrice() {
        return feePrice;
    }

    public List<Part> getPartList() {
        return partList;
    }
}
