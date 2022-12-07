package dat.backend.model.entities;

import dat.backend.model.services.Calculator;

import java.util.List;

public class BillOfMaterials {

    private List<Material> MaterialList;

    public static void main(String[] args) {
        System.out.println(Calculator.calcBeams(620+160, 530+70));
                                                // (1,etellerandet = 1 + 2 = 3 stolper) x (1 = 2) = 2 stolper // dvs i alt 4
    }

}
