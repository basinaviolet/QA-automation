package junit4.baseCalculator;

import com.it_academy.practice.junit_basics.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DivTest {
    Calculator calculator;
    private int a, b;
    private float c;

    public DivTest(int a, int b, float c) {
       this.a = a;
       this.b = b;
       this.c = c;
   }

    @Parameterized.Parameters
    public static Collection<Object[]> divCollection() {
        return Arrays.asList(new Object[][] {{3,2,1.5f}, {3,-2,-1.5f}, {0,1,0},
                {Integer.MAX_VALUE,2,1073741823},
                {Integer.MIN_VALUE,2,-1073741824},
                {Integer.MAX_VALUE,Integer.MIN_VALUE,-1},
                {Integer.MIN_VALUE,Integer.MAX_VALUE,-1}});
    }

    @Test
    public void testCheckingDivisionFunction() {
        calculator = new Calculator(a, b);
        assertEquals(c, calculator.calculate('/'), 0);
    }
}
