package junit4.baseCalculator;

import com.it_academy.practice.junit_basics.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SumTest {
    Calculator calculator;
    private int a, b;
    private float c;

    public SumTest(int a, int b, float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> sumCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 5}, {3, -2, 1}, {0, 0, 0},
                {Integer.MAX_VALUE, -1, 2147483646},
                {Integer.MIN_VALUE, 1, -2147483647},
                {Integer.MAX_VALUE, 1, 2147483648f},
                {Integer.MIN_VALUE, -1, -2147483649f},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, -1},
                {-Integer.MAX_VALUE, -Integer.MIN_VALUE, 1}});
    }

    @Test
    public void testCheckingSumFunction() {
        calculator = new Calculator(a, b);
        assertEquals(c, calculator.calculate('+'), 0);
    }
}
