package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calc = new Calculator();

    @Test
    public void testAddition() { assertEquals(5.0, calc.add(2, 3)); }
    @Test
    public void testSubtraction() { assertEquals(1.0, calc.subtract(3, 2)); }
    @Test
    public void testDivision() { assertEquals(2.0, calc.divide(4, 2)); }
    @Test
    public void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class, () -> calc.divide(1, 0));
    }
}
