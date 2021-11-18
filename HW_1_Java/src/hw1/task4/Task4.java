package main.task4;

import main.task4.logic.DataInsert;
import main.task4.logic.TaxiLogic;

import java.io.IOException;

public class Task4 {

    public static void main(String[] args) throws IOException {
        DataInsert taxiData = new DataInsert();
        TaxiLogic logic = new TaxiLogic();
        logic.taxiValue();
        logic.sortByFuelConsumption();
        logic.requestBySpeed("[5,40,50,70,120]");

        //  logic.getTaxiPool();


    }


}
