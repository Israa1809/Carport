package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Carport {

    private int length; //vi har besluttet at længde er det man også ville kalde dybden på carporten, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 7,8 m
    private int width; //vi har besluttet at bredden er målet fra højre til venstre, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 6,0 m
//    private int height; //udkommenteret fordi den mangler i db og skal sættes til noget default - hvis den er nødvendig, det er også et åbent spørgsmål
    private float materialFullPrice = 0;  //bør muligvis lægges som default i DB
    private float feePrice = 5000;  //bør muligvis lægges som default i DB
    private List<Part> partList = new ArrayList<>();

    public Carport(int length, int width) {
        this.length = length;
        this.width = width;
//        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

//    public int getHeight() {
//        return height;
//    }

    public float getMaterialFullPrice() {
        return materialFullPrice;
    }

    public float getFeePrice() {
        return feePrice;
    }

    public List<Part> getPartList() {
        return partList;
    }

    public void setMaterialFullPrice(float materialFullPrice) {
        this.materialFullPrice = materialFullPrice;
    }

    public void setFeePrice(float feePrice) {
        this.feePrice = feePrice;
    }

    public void setPartList(Part part) {
        partList.add(part);
        materialFullPrice = materialFullPrice + part.getPartPrice();
    }
}
