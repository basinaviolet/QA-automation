package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class SectionsFileReader {
    private static final String STR_SEPARATOR = ";";
    private static final File userFile = new File("/src/test/resources/checkSections.csv");

    public static Map<String, String[]> getSections() throws FileNotFoundException {
        final List<String[]> getListFromFile =
                readFile(new FileReader(System.getProperty("user.dir") + userFile));
        return getSectionsMap(getListFromFile);
    }

    // reading line from file with check list parameters
    public static List<String[]> readFile(FileReader file) {
        List<String[]> itemCheckList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            fileScanner.nextLine();
            String newLine;

            while (fileScanner.hasNextLine()) {
                newLine = fileScanner.nextLine();
                itemCheckList.add(newLine.split(STR_SEPARATOR));
            }
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return itemCheckList;
    }

    public static Map<String, String[]> getSectionsMap(List<String[]> item) {
        Map<String, String[]> sections = new HashMap<>();

        for (String[] i : item) {
            if (i[0].trim().compareTo("") != 0) {
                sections.put(i[0].trim(), getSectionPoints(i));
            }
        }

        return sections;
    }

    public static String[] getSectionPoints(String[] item) {
        int length = 0;

        for (int i = 1; i < item.length; i++) {
            if (item[i].trim().compareTo("") != 0) length++;
        }

        String[] result = new String[length];
        if (length > 0) {
            int num = 0;
            for (int i = 1; i < item.length; i++) {
                if (item[i].trim().compareTo("") != 0) {
                    result[num] = item[i].trim();
                    num++; }
            }
        }

        return result;
    }
}
