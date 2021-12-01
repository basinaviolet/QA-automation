package junit4.baseCalculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = {SumTest.class, DiffTest.class, MultiTest.class, DivTest.class, ErrorsTest.class})

public class TestSuite {

}
