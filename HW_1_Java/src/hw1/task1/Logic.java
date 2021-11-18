package main.task1;

import java.util.Scanner;

public class Logic {

    public int getNumber(){

        Scanner inputPer = new Scanner(System.in);

        while (!inputPer.hasNextInt()) {
            System.out.println("Enter correct number from 1 to 7: ");
            inputPer.next();
        }

        return inputPer.nextInt();
    }
}
