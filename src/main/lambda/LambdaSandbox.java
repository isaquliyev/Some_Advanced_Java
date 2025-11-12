package lambda;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.IntStream;

public class LambdaSandbox {

    public static Integer[] createArray(int n, Function<Integer, Integer> f) {
        Integer[] arr = new Integer[n];
        IntStream.range(0, n).forEach(x -> arr[x] = f.apply(x));
        return arr;
    }

    public static Integer[][] createMatrix(int n, int m, BiFunction<Integer, Integer, Integer> f) {
        Integer[][] arr = new Integer[n][m];
        IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> arr[i][j] = f.apply(i, j)));
        return arr;
    }

}


