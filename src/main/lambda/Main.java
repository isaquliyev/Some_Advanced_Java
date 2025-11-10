package lambda;
import java.util.Arrays;
import java.util.function.BiFunction;


public class Main {

    public static void main(String[] args) {

        /// Args are like ["apple", "banana"]

        Arrays.stream(args).sorted(
                countSorterStringBased::apply
        ).forEach(System.out::println);

    }

    private static final BiFunction<String, String, Integer> countSorterStringBased =
            (s1, s2) -> Math.toIntExact(s1.chars().filter(c -> c == 'a' || c == 'A').count()
                    - s2.chars().filter(c -> c == 'a' || c == 'A').count());
}

