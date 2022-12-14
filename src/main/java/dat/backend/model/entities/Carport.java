package dat.backend.model.entities;

import java.util.ArrayList;
import java.util.List;

public class Carport {

    private int length; //vi har besluttet at længde er det man også ville kalde dybden på carporten, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 7,8 m
    private int width; //vi har besluttet at bredden er målet fra højre til venstre, når man står ved indgangen hvor bilen kan køre ind. I eksemplet er det 6,0 m
    private int height = 210; //udkommenteret fordi den mangler i db og skal sættes til noget default - hvis den er nødvendig, det er også et åbent spørgsmål
    private float materialFullPrice;  //bør muligvis lægges som default i DB
    private float feePrice;  //bør muligvis lægges som default i DB
    private float carportFullPrice;
    private List<Part> partList = new ArrayList<>();
    private int carportId;
    Boolean offerStatus;
    Boolean paymentStatus;

    public Carport(int length, int width) {
        this.length = length;
        this.width = width;
        this.materialFullPrice = 0;
        this.feePrice = 5000;
        this.carportFullPrice = materialFullPrice + feePrice;
    }

    public Carport(int length, int width, float materialFullPrice, float feePrice, int carportId, boolean offerStatus, boolean paymentStatus){
        this.length = length;
        this.width = width;
        this.materialFullPrice = materialFullPrice;
        this.feePrice = feePrice;
        this.carportFullPrice = materialFullPrice + feePrice;
        this.carportId = carportId;
        this.offerStatus = offerStatus;
        this.paymentStatus = paymentStatus;
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

    public void setMaterialFullPrice(float materialFullPrice) {
        this.materialFullPrice = materialFullPrice;
    }

    public void setFeePrice(float feePrice) {
        this.feePrice = feePrice;
    }

    public float getCarportFullPrice() {
        return carportFullPrice;
    }

    public void setPartListFirstTime(Part part) {
        partList.add(part);
        materialFullPrice = materialFullPrice + part.getPartPrice();
    }

    public void setPartListFromDB(Part part) {
        partList.add(part);
    }

    public int getCarportId() {
        return carportId;
    }

    public void setCarportId(int carportId) {
        this.carportId = carportId;
    }

    public Boolean getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(Boolean offerStatus) {
        this.offerStatus = offerStatus;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
