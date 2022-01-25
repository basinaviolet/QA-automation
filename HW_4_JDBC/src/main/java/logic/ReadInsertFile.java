package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadInsertFile {
    private static final String STR_SEPARATOR = ";";
    private static final String UserfileUrl = "/src/main/resources/insertUserToDB.csv";
    private static final String AccfileUrl = "/src/main/resources/insertAccToDB.csv";
    private static final String TransfileUrl = "/src/main/resources/insertTransactionToDB.csv";


    // reading line from file with check list parameters
    public static List<String[]> readFile(String identifier) {
        List<String[]> itemList = new ArrayList<>();
        String fileUrl = "";

        switch (identifier){
            case "user": fileUrl = UserfileUrl; break;
            case "account": fileUrl = AccfileUrl; break;
            case "transaction": fileUrl = TransfileUrl; break;
        }

        if (fileUrl.compareTo("") != 0){
            File insertFile = new File(System.getProperty("user.dir") + fileUrl);
            try (Scanner fileScanner = new Scanner(insertFile)) {
                fileScanner.nextLine();
                String newLine;
                while (fileScanner.hasNextLine()) {
                    newLine = fileScanner.nextLine();
                    itemList.add(newLine.split(STR_SEPARATOR));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return itemList;
    }
}
