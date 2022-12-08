package dat.backend.model.entities;

public class Main {

    public static void main(String[] args) {
        Carport carport = BillOfMaterials.buildCarport(new Carport(780, 600));
        System.out.println(carport.getPartList());


    }

}
