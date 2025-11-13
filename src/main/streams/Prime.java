package streams;

import java.util.stream.IntStream;

public class Prime {


    /**
     * The function that checks if number is prime
     * @param n The provided number
     * @return Boolean value. If number is prime then true, false otherwise
     */
    static public boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;


        return IntStream.iterate(5, i -> i * i <= n, i -> i + 6)
                .noneMatch(i -> n % i == 0 || n % (i + 2) == 0);

    }

    /**
     * The function that gets next prime number
     * @param n Initial integer
     * @return Next prime number of given integer
     */
    static public int nextPrime(int n) {
        return IntStream.iterate(n + 1, i -> i + 1)
                .filter(Prime::isPrime).findFirst().orElseThrow();
    }
}
