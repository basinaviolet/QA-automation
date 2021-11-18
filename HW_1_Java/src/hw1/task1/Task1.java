package main.task1;

public class Task1 {
    public static void  main(String[] args) {

        System.out.println("Input integer number from 1 to 7: ");
        System.out.println("day is: "
                + DaysBatabase.values() [inputDayNumber()-1]);

    }

    public static int inputDayNumber() {
        Logic help = new Logic();
        int dayNumber = help.getNumber();

        while ((dayNumber < 1) || (dayNumber > 7)){
            dayNumber = help.getNumber();
        }
        return dayNumber;
    }

}
