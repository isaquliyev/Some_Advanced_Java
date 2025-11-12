package lambda;

import java.util.Arrays;
import java.util.function.*;
import java.util.stream.IntStream;

public class LambdaSandbox {

    /**
     * Method that returns new array. Elements of new array are implementation of function [f] for index i which is in [0 ... n]
     * @param n Length of array that will be returned
     * @param f The lambda function that applied for each indexes of array
     * @return New array
     */
    public static Integer[] createArray(int n, Function<Integer, Integer> f) {
        Integer[] arr = new Integer[n];
        IntStream.range(0, n).forEach(x -> arr[x] = f.apply(x));
        return arr;
    }

    /**
     * Method that returns new array. Elements of new array are implementation
     * of function [f] for index i which is in [0 ... n] and j which is in [0 ... m]
     * @param n Number of rows in return matrix
     * @param m Number of columns in return matrix
     * @param f The BiFunction that applies for i, f
     * @return n x m array that holds values f(i, j)
     */
    public static Integer[][] createMatrix(int n, int m, BiFunction<Integer, Integer, Integer> f) {
        Integer[][] arr = new Integer[n][m];
        IntStream.range(0, n).forEach(i -> IntStream.range(0, m).forEach(j -> arr[i][j] = f.apply(i, j)));
        return arr;
    }

    /**
     * Method that takes two Function and unite them into one function.
     * @param f First function
     * @param g Second function
     * @return New function which is composition of f and g
     */
    public static Function<Integer, Integer> compose(Function<Integer, Integer> f, Function<Integer, Integer> g) {
        return (x) -> f.apply(g.apply(x));
    }

}


