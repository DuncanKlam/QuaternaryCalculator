import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private final String LARGEST_INPUT = "3333333";

    @Test
    public void testComputeAdd() {
        Assertions.assertEquals("2", Calculator.compute("1", "1", "+"));
    }

    @Test
    public void testComputeSub() {
        Assertions.assertEquals("2", Calculator.compute("10", "2", "-"));
    }

    @Test
    public void testComputeMul() {
        Assertions.assertEquals("20", Calculator.compute("10", "2", "x"));
    }

    @Test
    public void testComputeDiv() {
        Assertions.assertEquals("2", Calculator.compute("10", "2", "/"));
    }

    @Test
    public void testAddZeros() {
        String expected = "0";
        Assertions.assertEquals(expected, Calculator.add("0","0"));
    }

    @Test
    public void testAddVariousNums() {
        String[] expected = {"3", "10", "23", "333", "1000", "321321"};

        String[] actual = new String[6];
        actual[0] = Calculator.add("1", "2");
        actual[1] = Calculator.add("2", "2");
        actual[2] = Calculator.add("11", "12");
        actual[3] = Calculator.add("123", "210");
        actual[4] = Calculator.add("333", "1");
        actual[5] = Calculator.add("321321", "0");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testAddLargeNums() {
        String expected = "13333332";
        Assertions.assertEquals(expected, Calculator.add(LARGEST_INPUT, LARGEST_INPUT));
    }

    @Test
    void sub() {
    }

    @Test
    void testMulZeros() {
        String expected = "0";
        Assertions.assertEquals(expected,Calculator.mul("0", "0"));
    }

    @Test
    void testMulVariousNums() {
        String[] expected = {"1", "20", "3120", "2002131121"};

        String[] actual = new String[4];
        actual[0] = Calculator.mul("1", "1");
        actual[1] = Calculator.mul("10", "2");
        actual[2] = Calculator.mul("123", "20");
        actual[3] = Calculator.mul("23123", "23123");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testMulLargeNums() {
        String expected = "33333320000001";
        Assertions.assertEquals(expected, Calculator.mul(LARGEST_INPUT, LARGEST_INPUT));
    }

    @Test
    void div() {
    }

    @Test
    void root() {
    }

    @Test
    void testSquareZero() {
        String expected = "0";
        Assertions.assertEquals(expected, Calculator.square("0"));
    }

    @Test
    void testSquareVariousNums() {
        String[] expected = {"1", "10", "23121", "3101112010"};
        String[] actual = new String[4];
        actual[0] = Calculator.square("1");
        actual[1] = Calculator.square("2");
        actual[2] = Calculator.square("123");
        actual[3] = Calculator.square("32132");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testSquareLargestInput() {
        String expected = "33333320000001";
        Assertions.assertEquals(expected, Calculator.square(LARGEST_INPUT));
    }

    @Test
    void testParsePlus(){
        String expected = "+";
        Assertions.assertEquals(expected, Calculator.parseCalculation("123123+42112"));
    }
    @Test
    void testParseMinus(){
        String expected = "-";
        Assertions.assertEquals(expected, Calculator.parseCalculation("123123-42112"));
    }
    @Test
    void testParseMult(){
        String expected = "x";
        Assertions.assertEquals(expected, Calculator.parseCalculation("123123x42112"));
    }
    @Test
    void testParseDiv(){
        String expected = "/";
        Assertions.assertEquals(expected, Calculator.parseCalculation("123123/42112"));
    }

    @Test
    void testCalculatePlus(){
        String expected = "2";
        Assertions.assertEquals(expected, Calculator.calculate("1+1"));
    }

    @Test
    void testCalculateEmptyCalculationValueRight(){
        String expected = "2";
        Assertions.assertEquals(expected, Calculator.calculate("2+"));
    }

    @Test
    void testCalculateEmptyCalculationValueLeft(){
        String expected = "2";
        Assertions.assertEquals(expected, Calculator.calculate("+2"));
    }
}
