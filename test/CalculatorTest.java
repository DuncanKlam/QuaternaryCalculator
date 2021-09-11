import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAddZeros() {
        String expected = "0";
        Assertions.assertEquals(expected, Calculator.add("0","0"));
    }

    @Test
    void testAddLargeNums() {
        String expected = "13333332";
        String largeNum = "3333333";
        Assertions.assertEquals(expected, Calculator.add(largeNum, largeNum));
    }

    @Test
    void sub() {
    }

    @Test
    void mul() {
    }

    @Test
    void div() {
    }

    @Test
    void root() {
    }

    @Test
    void square() {
    }
}
