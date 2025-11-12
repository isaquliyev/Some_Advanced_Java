package lambda;

import enums.Weekday;

import java.util.Arrays;
import java.util.function.BiFunction;


public class Main {

    public static void main(String[] args) {

        //Arrays.stream(LambdaSandbox.createArray(5, (integer -> 2 * integer))).forEach(System.out::print);

        Arrays.stream(LambdaSandbox.createMatrix(2, 8, ((n, m) -> 2 * n + 3 * m))).forEach(arr -> Arrays.stream(arr).forEach(System.out::println));


    }

    private static final BiFunction<String, String, Integer> countSorterBasedOnA =
            (s1, s2) -> Math.toIntExact(s1.chars().filter(c -> c == 'a' || c == 'A').count()
                    - s2.chars().filter(c -> c == 'a' || c == 'A').count());

    private static final BiFunction<String, String, Integer> sorterBasedOnWeekday =
            (s1, s2) -> Weekday.isWeekday.test(s1) && !Weekday.isWeekday.test(s2) ? -1
                    : !Weekday.isWeekday.test(s1) && Weekday.isWeekday.test(s2) ? 1
                    : !Weekday.isWeekday.test(s1) && !Weekday.isWeekday.test(s2) ? -1
                    : - Weekday.getWeekdayForGivenName.apply(s2).ordinal()
                    + Weekday.getWeekdayForGivenName.apply(s1).ordinal()
            ;
}

