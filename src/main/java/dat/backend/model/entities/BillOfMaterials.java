package dat.backend.model.entities;

import dat.backend.model.services.Calculator;

import java.util.List;

public class BillOfMaterials {

    private List<Material> MaterialList;

    public static void main(String[] args) {
        System.out.println(Calculator.calcBeams(310+310+20+160, 530+20+70));
                                                // (2,06 = 2 + 1 + 1 = 4 stolper) x (1,03 = 1 + 1 + 1 = 3 stolper // dvs i alt 12
    }

}
