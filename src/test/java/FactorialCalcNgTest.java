import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class FactorialCalcNgTest {

    @Test
    public void testFactorialOfZero() {
        FactorialCalc calc = new FactorialCalc();
        assertEquals(1, calc.factorial(0));
    }

    @Test
    public void testFactorialOfPositiv() {
        FactorialCalc calc = new FactorialCalc();
        assertEquals(720, calc.factorial(6));
    }

    @Test(expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Недопустимое значение для вычисления факториала")
    public void testFactorialOfNegativ() {
        FactorialCalc calc = new FactorialCalc();
        calc.factorial(-1);
    }
}