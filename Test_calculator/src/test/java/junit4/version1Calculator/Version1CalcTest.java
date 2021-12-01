package junit4.version1Calculator;

import com.it_academy.practice.junit_basics.CalculatorVersion1;
import junit4.version1Calculator.file.CheckListFileReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class Version1CalcTest {
    CalculatorVersion1 calculator;
    private int a, b;
    private float c;
    private char operation;

    public Version1CalcTest(int a, int b, float c, char operation) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.operation = operation;
    }

    @Parameterized.Parameters (name = "{0} {3} {1} = {2}")
    public static Collection<Object[]> checkListCollection() {
        Collection<Object[]> checkCollection = new ArrayList<>();
        File userFile = new File("/src/test/resources/forTesting/checkList.csv");

        final List<String[]> checkListFromFile =
                CheckListFileReader.readFile(new File(System.getProperty("user.dir") + userFile));
        List<Object[]> listForTest = new ArrayList<>();

        checkListFromFile.stream().filter(item -> (item[5].indexOf("Error") < 0)).collect(Collectors.toList()).forEach(itemList ->
                checkCollection.add(new Object[]{CheckListFileReader.parameterForIntList(itemList[3]),
                        CheckListFileReader.parameterForIntList(itemList[4]),
                        CheckListFileReader.resultForList(itemList[5]),
                        itemList[0].charAt(0)}));
        return checkCollection;
    }

    @Test
    public void testCheckingSumFunction() {
        calculator = new CalculatorVersion1(a, b);
        assertEquals(c, calculator.calculate(operation), 0.0001);
    }
}
