package junit4.baseCalculator;

import com.it_academy.practice.junit_basics.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ErrorsTest {
    Calculator calculator;
    private int a, b;
//    private float c;
    private char operation;

    public ErrorsTest(int a, int b, char operation) {
        this.a = a;
        this.b = b;
//        this.c = c;
        this.operation = operation;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> errorCollection() {
        return Arrays.asList(new Object[][] {{1, 0, '/'}});
    }

    @Test(expected = ArithmeticException.class)
    public void testCheckingErrors() {
        calculator = new Calculator(a, b);
        assertEquals(0, calculator.calculate(operation), 0);
    }
}
