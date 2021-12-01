package junit4.version1Calculator.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckListFileReader {
    private static final String STR_SEPARATOR = ";";

    // reading line from file with check list parameters
    public static List<String[]> readFile(File file) {
        List<String[]> itemCheckList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            fileScanner.nextLine();
            String newLine;
            while (fileScanner.hasNextLine()) {
                newLine = fileScanner.nextLine();
                itemCheckList.add(newLine.split(STR_SEPARATOR));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemCheckList;
    }

    public static int parameterForIntList(String item) {
        if (item.indexOf("MIN_VALUE") == 0) {
            return Integer.MIN_VALUE;
        } else if (item.indexOf("MIN_VALUE") == 1) {
            return -Integer.MIN_VALUE;
        } else if (item.indexOf("MAX_VALUE") == 0) {
            return Integer.MAX_VALUE;
        } else if (item.indexOf("MAX_VALUE") == 1) {
            return -Integer.MAX_VALUE;
        } else return Integer.parseInt(item);
    }

    public static float parameterForFloatList(String item) {
        if (item.indexOf("MIN_VALUE") == 0) {
            return Integer.MIN_VALUE;
        } else if (item.indexOf("MIN_VALUE") == 1) {
            return -Integer.MIN_VALUE;
        } else if (item.indexOf("MAX_VALUE") == 0) {
            return Integer.MAX_VALUE;
        } else if (item.indexOf("MAX_VALUE") == 1) {
            return -Integer.MAX_VALUE;
        } else return Float.parseFloat(item);
    }

    public static float resultForList(String item) {
        if (item.indexOf("Error") >= 0) {
            return 0;
        } else return parameterForFloatList(item);
    }
}
