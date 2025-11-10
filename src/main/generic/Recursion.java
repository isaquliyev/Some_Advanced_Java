package generic;

import java.util.function.LongUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Recursion {

    public static long factorial(long n) {
        return n <= 1 ? 1 : factorial(n - 1) * n;
    }


    public static LongUnaryOperator factorialStream =
            (n) -> LongStream.rangeClosed(0, n)
                    .reduce((x, y) -> x * y).orElse(1);
    public static void main(String[] args) {
        System.out.println(factorialStream.applyAsLong(6));
        System.out.println(factorial(5));
    }
}
