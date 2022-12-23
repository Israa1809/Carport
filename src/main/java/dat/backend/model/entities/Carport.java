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
    private ArrayList<Part> partList = new ArrayList<>();
    private int carportId;
    Boolean offerStatus;
    Boolean paymentStatus;
    Boolean hasShed;

    public Carport(int length, int width, Boolean hasShed) {
        this.length = length;
        this.width = width;
        this.materialFullPrice = 0;
        this.feePrice = 5000;
        this.carportFullPrice = materialFullPrice + feePrice;
        this.hasShed =  hasShed;
    }

    public Carport(int length, int width, float materialFullPrice, float feePrice, int carportId, boolean offerStatus, boolean paymentStatus,  Boolean hasShed){
        this.length = length;
        this.width = width;
        this.materialFullPrice = materialFullPrice;
        this.feePrice = feePrice;
        this.carportFullPrice = materialFullPrice + feePrice;
        this.carportId = carportId;
        this.offerStatus = offerStatus;
        this.paymentStatus = paymentStatus;
        this.hasShed =  hasShed;
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

    public ArrayList<Part> getPartList() {
        return partList;
    }

    public void setMaterialFullPrice(float materialFullPrice) {
        this.materialFullPrice = materialFullPrice;
    }

    public void setFeePrice(float feePrice) {
        this.feePrice = feePrice;
    }

    public float getCarportFullPrice() {
        return carportFullPrice = materialFullPrice + feePrice;
    }

    public void addPartFirstTime(Part part) {
        partList.add(part);
        materialFullPrice = materialFullPrice + part.getPartPrice();
    }

    public void addPartFromDB(Part part) {
        partList.add(part);
    }

    public void setPartList(ArrayList<Part> partList){      //hjælp til at ændre i carportmål for admin på "redigering af carport" uden at ændre carportId / username
        this.partList = partList;
        this.materialFullPrice = 0;
        for (Part part : partList) {
            materialFullPrice = materialFullPrice + part.getPartPrice();
        }
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

    public Boolean getHasShed() {
        return hasShed;
    }

    public void setHasShed(Boolean hasShed) {
        this.hasShed = hasShed;
    }
}
