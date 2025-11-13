package streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsSandbox {
    public static void main(String[] args) {

        /// IntStream.range(0, args.length).mapToObj(i -> args[args.length - 1 - i]).forEach(System.out::println);

        /// System.out.println(
        /// Arrays.stream(args).filter(s -> s.matches("[0-9]+")).mapToInt(Integer::parseInt).filter(x -> x > 8 && x % 2 == 0).sum());

        Stream.iterate(2, Prime::nextPrime).limit(8).forEach(System.out::println);
    }
}
