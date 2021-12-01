package junit4.baseCalculator;

import com.it_academy.practice.junit_basics.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MultiTest {
    Calculator calculator;
    private int a, b;
    private float c;

    public MultiTest(int a, int b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> multiCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 6}, {3, -2, -6}, {0, 0, 0}, {1, 0, 0},
                {Integer.MAX_VALUE, 1, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, -1, -2147483647},
                {Integer.MIN_VALUE, 1, Integer.MIN_VALUE},
                {Integer.MIN_VALUE, -1, 2147483648f},
                {Integer.MIN_VALUE, 2, -4294967296f},
                {Integer.MAX_VALUE, 2, -4294967294f}});
    }

    @Test
    public void testCheckingSMultiplicationFunction() {
        calculator = new Calculator(a, b);
        assertEquals(c, calculator.calculate('*'), 0);
    }
}
