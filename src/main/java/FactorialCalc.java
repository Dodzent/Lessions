public class FactorialCalc {

    public int factorial(int f) {
        if (f < 0) {
            throw new IllegalArgumentException("Недопустимое значение для вычисления факториала");
        }
        int factorialResult = 1;
        for (int i = 1; i <= f; i++) {
            factorialResult*=i;
        }
        return factorialResult;
    }
}

