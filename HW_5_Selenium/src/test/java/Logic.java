import com.codeborne.selenide.junit5.ScreenShooterExtension;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(ScreenShooterExtension.class)
public class Logic {

    public static Object[] getItemListFromPageList(Object[] listFromPage) {
        return Arrays.stream(listFromPage)
                .filter(i -> i.toString().trim().compareTo("") != 0).toArray();
    }

    public static int getNumComparedItems(Object[] arrayForCheck, Object[] arrayFromPage) {
        int check = 0;
        for (Object i : arrayForCheck) {
            boolean checkItem = false;
            for (Object iInternal : arrayFromPage) {
                if (iInternal.toString().compareTo(i.toString()) == 0)
                    checkItem = true;
            }
            if (checkItem) check++;
        }
        return check;
    }

    public static int getNumCheckItemsOfOptionPoint(Object[] arrayForCheck) {
        String checkProduct = "товар";
        String checkPrice = "от";

        int check = 0;
        for (Object item : arrayForCheck) {
            boolean checkItem = false;
            if (item.toString().compareTo("") != 0) {
                if ((item.toString().indexOf(checkProduct) >= 0) && (item.toString().indexOf(checkPrice) >=0)) {
                    checkItem = true;
                }
            }
            if (checkItem) check++;
        }
        return check;
    }

    public static Map<String, String[]> getComparedOptionPointsItems(Object[] arrayFull, Object[] arrayTitles) {
        int iForTitles = 0;
        Map<String, String[]> resultList = new HashMap<>();

        for (int i = 0; i < arrayFull.length; i++) {
            System.out.println(i + ":" + arrayFull[i]);
            if (arrayFull[i].toString().compareTo(arrayTitles[iForTitles].toString()) == 0) {
                System.out.println(iForTitles + "тут");
                resultList.put(
                        arrayFull[i].toString(),
                        new String[]{
                                (arrayFull[i + 1].toString().compareTo(arrayTitles[iForTitles + 1].toString()) != 0) ? arrayFull[i + 1].toString() : "",
                                (arrayFull[i + 2].toString().compareTo(arrayTitles[iForTitles + 1].toString()) != 0) ? arrayFull[i + 2].toString() : ""
                        }
                );
                System.out.println(arrayFull[i].toString() + ":"
                        + ((arrayFull[i + 1].toString().compareTo(arrayTitles[iForTitles + 1].toString()) != 0) ? arrayFull[i + 1].toString() : "")
                        + ((arrayFull[i + 2].toString().compareTo(arrayTitles[iForTitles + 1].toString()) != 0) ? arrayFull[i + 2].toString() : ""));
                iForTitles++;
            }
        }
        return resultList;
    }
}
