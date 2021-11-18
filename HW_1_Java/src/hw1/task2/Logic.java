package main.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
    public List<Float> getNumberList() {

        Scanner inputPer = new Scanner(System.in);
        List numberContainer = new ArrayList<Float>();

        while (!inputPer.hasNext("end")){
            while (!inputPer.hasNextFloat()) {
                System.out.println("Enter correct double number");
                inputPer.next();
            }
            numberContainer.add(inputPer.nextFloat());
        }

        return numberContainer;
    }

    public String toPrint (String text, int mantissa1, int mantissa2){
        return "the minimum " + text + ": %." + mantissa1
                + "f {%d},  the maximum " + text + ": %." +  mantissa2
                + "f, {%d} /n";
    }
}
