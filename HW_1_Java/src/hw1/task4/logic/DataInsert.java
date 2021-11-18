package main.task4.logic;

import main.task4.structure.*;
import main.task4.structure.BusinessClass;
import main.task4.structure.EconomClass;
import main.task4.structure.KidsClass;
import main.task4.structure.PassengerCar;

import java.io.IOException;
import java.util.*;

public class DataInsert {
    private static final String SPACE = "\\s+";
    private static final String EQUAL = "=";
    private static final String CLASS_TYPE = ":";
    private static final String END_PARAMS = ", ";
    private static final String COMA = ",";

    FileDAO getFile = new FileDAO();
    List<PassengerCar> economClassList = new ArrayList<PassengerCar>();
    List<PassengerCar> busClassList = new ArrayList<PassengerCar>();
    List<PassengerCar> kidsClassList = new ArrayList<PassengerCar>();

    /* getTaxiListFromFile
     * get list of taxi by classes with sending the correct class of taxi
     * return: void
     */
    public void getTaxiListFromFile() throws IOException {

        List<String> taxiList = getFile.readFile();

        for (String line : taxiList) {
            String[] taxiLine = line.split(CLASS_TYPE);

            switch (taxiLine[0]) {
                case ("Econom"):
                    if (taxiLine[1].contains("countOfKidsPlace")) {
                        addToClassList(KidsClass.class, taxiLine[1]);
                    } else {
                        addToClassList(EconomClass.class, taxiLine[1]);
                    }
                    break;
                case ("Business"):
                    addToClassList(BusinessClass.class, taxiLine[1]);
                    break;
            }
        }
    }

    /* addToClassList
     * take class of taxi type and line from file
     * check line and add the parameters to the taxi list
     * return: void
     */
    public void addToClassList(Class carClass, String lineToList) {
        Map<String, String> newTaxiParameters;
        newTaxiParameters = getTaxiParameters(lineToList);

        //check parameters and adding null
        //      newTaxiParameters = checkFields(listClass, newTaxiParameters);

        switch (carClass.getSimpleName()) {
            case ("KidsClass"):
                kidsClassList.add(getNewTaxiItem(carClass, newTaxiParameters));
                break;
            case ("EconomClass"):
                economClassList.add(getNewTaxiItem(carClass, newTaxiParameters));
                break;
            case ("BusinessClass"):
                busClassList.add(getNewTaxiItem(carClass, newTaxiParameters));
                break;
        }

    }

    /* getTaxiParameters
     * splitting the line from file to Map with pair of key&value
     *  return: Map with parameters for entering to List
     */
    public Map<String, String> getTaxiParameters(String line) {
        Map<String, String> taxiParams = new HashMap<>();
        String[] lineItem = line.trim().split(END_PARAMS);
        String[] item = new String[lineItem.length];

        for (int i = 0; i < lineItem.length; i++) {
            item = lineItem[i].split(EQUAL);
            taxiParams.put(item[0], item[1]);
        }
        return taxiParams;
    }

    /* getNewTaxiItem
     * generate new item of taxi for inset in the List
     *  return: new taxi item
     */
    public PassengerCar getNewTaxiItem(Class carClass, Map<String, String> forInsert) {

        PassengerCar newTaxiItem = null;
        int[] speed = new int[5];

        if (forInsert.containsKey("speed")) {
            speed = speedToArray(forInsert.get("speed"));
        }

        switch (carClass.getSimpleName()) {
            case ("KidsClass"):
                newTaxiItem = new KidsClass(forInsert.get("licensePlate"),
                        forInsert.get("brand"),
                        forInsert.get("taxiType"),
                        forInsert.get("bodyworkType"),
                        Float.parseFloat(forInsert.get("price")),
                        Float.parseFloat(forInsert.get("fuelConsumption")),
                        speed,
                        Integer.parseInt(forInsert.get("startCost")),
                        Integer.parseInt(forInsert.get("countOfPassengers")),
                        Boolean.parseBoolean(forInsert.get("kidsPlace")),
                        Integer.parseInt(forInsert.get("countOfKidsPlace")));
                break;
            case ("EconomClass"):
                newTaxiItem = new EconomClass(forInsert.get("licensePlate"),
                        forInsert.get("brand"),
                        forInsert.get("taxiType"),
                        forInsert.get("bodyworkType"),
                        Float.parseFloat(forInsert.get("price")),
                        Float.parseFloat(forInsert.get("fuelConsumption")),
                        speed,
                        Integer.parseInt(forInsert.get("startCost")),
                        Integer.parseInt(forInsert.get("countOfPassengers")));
                break;
            case ("BusinessClass"):
                newTaxiItem = new BusinessClass(forInsert.get("licensePlate"),
                        forInsert.get("brand"),
                        forInsert.get("taxiType"),
                        forInsert.get("bodyworkType"),
                        Float.parseFloat(forInsert.get("price")),
                        Float.parseFloat(forInsert.get("fuelConsumption")),
                        speed,
                        Integer.parseInt(forInsert.get("startCost")),
                        Integer.parseInt(forInsert.get("numberOfBusinessClass")));
                break;
        }
        return newTaxiItem;
    }

    /*
     * restructuring speed string to array
     */
    public int[] speedToArray(String speedStr) {
        int[] speedArray = new int[5];

        String[] valueForSpeed = speedStr.substring(1, speedStr.length() - 1).split(COMA);

        if (valueForSpeed.length == 5) {
            for (int i = 0; i < valueForSpeed.length; i++) {
                speedArray[i] = Integer.parseInt(valueForSpeed[i]);
            }
        }
        return speedArray;
    }
}
