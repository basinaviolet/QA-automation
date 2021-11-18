package main.task4.logic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {

    File taxiFile = new File("/src/main/task4/sources/taxi.txt");

    public List<String> readFile() throws IOException {

        FileReader fileReader;
        List<String> taxiList = new ArrayList<>();
        try {
            fileReader = new FileReader(System.getProperty("user.dir") + taxiFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;

            while ((line = reader.readLine()) != null) {
                taxiList.add(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxiList;
    }
}
