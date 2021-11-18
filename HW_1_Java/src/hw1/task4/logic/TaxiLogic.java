package main.task4.logic;

import main.task4.structure.PassengerCar;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class TaxiLogic {
    DataInsert getData = new DataInsert();

    /* getAllGroup
     * get list of taxi by classes and collecting them in total one
     * return: total list with all cars in the pool
     */
    public List<PassengerCar> getAllGroup() throws IOException {
        List<PassengerCar> newList = new ArrayList<>();

        getData.getTaxiListFromFile();
        newList.addAll(getData.economClassList);
        newList.addAll(getData.kidsClassList);
        newList.addAll(getData.busClassList);

        return newList;
    }

    /* getTaxiPool
     * get list of taxi by classes with sending the correct class of taxi + print them to console
     * return: void
     */
    public void getTaxiPool() throws IOException {
        getData.getTaxiListFromFile();
        listToPrint(getData.economClassList, "Economy class:");
        listToPrint(getData.kidsClassList, "with kids places:");
        listToPrint(getData.busClassList, "Business class:");
    }

    public void taxiValue() throws IOException {
        List<PassengerCar> fullList = getAllGroup();
        int value = 0;
        value = fullList.stream()
                .mapToInt(valueItem -> valueItem.getStartCost()).sum();

        System.out.println("Value of taxi pool: " + value);
    }

    public void sortByFuelConsumption() throws IOException {
        List<PassengerCar> fullList = getAllGroup();

        fullList.sort(Comparator.comparing(item -> item.getFuelConsumption()));
        listToPrint(fullList, "Sort by Fuel consumption:");
    }

    public void requestBySpeed(String speedStr) throws IOException {
        List<PassengerCar> fullList = getAllGroup();
        int[] speedPattern = getData.speedToArray(speedStr);

        List<PassengerCar> speedList = fullList.stream()
                .filter(item -> (speedPattern[0] <= item.getSpeed()[0])
                        && (speedPattern[1] > item.getSpeed()[0])
                        && (speedPattern[1] <= item.getSpeed()[1])
                        && (speedPattern[2] > item.getSpeed()[1])
                        && (speedPattern[2] <= item.getSpeed()[2])
                        && (speedPattern[3] > item.getSpeed()[2])
                        && (speedPattern[3] <= item.getSpeed()[3])
                        && (speedPattern[4] > item.getSpeed()[3])
                        && (speedPattern[4] <= item.getSpeed()[4]))
                .collect(Collectors.toList());

        listToPrint(speedList, "speed " + speedStr + ":");
    }

    public void listToPrint(List<PassengerCar> toPrn, String str) {
        System.out.println("\n" + str);
        for (PassengerCar carItem : toPrn) {
            System.out.println(carItem);
        }
    }

}
