import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalcTest {
    @Test
    public void testFactorialOfZero() {
        FactorialCalc calc = new FactorialCalc();
        assertEquals(1, calc.factorial(0));
    }

    @Test
    public void testFactorialOfPositive() {
        FactorialCalc calc = new FactorialCalc();
        assertEquals(120, calc.factorial(5)); // 5! = 120
    }

    @Test
    public void testFactorialOfNegative() {
        FactorialCalc calc = new FactorialCalc();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calc.factorial(-1);
        });
        assertEquals("Недопустимое значение для вычисления факториала", exception.getMessage());
    }
}
