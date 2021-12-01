package junit4.baseCalculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcTest {
    private int a, b, c;

    public CalcTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> sumCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 5}, {3, -2, 1}, {0, 0, 0},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 0},
                {-Integer.MAX_VALUE, Integer.MAX_VALUE, 0}});
    }

    @Parameterized.Parameters
    public static Collection<Object[]> minesCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 1}, {3, -2, 5}, {0, 0, 0},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, -Integer.MAX_VALUE, 0}});
    }

    @Parameterized.Parameters
    public static Collection<Object[]> divCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 1.5}, {3, -2, -1.5}, {0, 1, 0},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 0},
                {-Integer.MAX_VALUE, Integer.MAX_VALUE, 0}});
    }

    @Parameterized.Parameters
    public static Collection<Object[]> multiCollection() {
        return Arrays.asList(new Object[][]{{3, 2, 6}, {3, -2, -6}, {0, 0, 0},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0},
                {Integer.MIN_VALUE, Integer.MIN_VALUE, 0},
                {Integer.MAX_VALUE, Integer.MIN_VALUE, 0},
                {-Integer.MAX_VALUE, Integer.MAX_VALUE, 0}});
    }

    @Test
    public void calculatorTest() {

    }
}
