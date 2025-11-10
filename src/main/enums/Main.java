package enums;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        //IntStream.range(0, 14).forEach(i -> System.out.println(Weekday.callBasedWeekdaySupplier.get()));

        IntStream.range(0, 2).forEach(i -> System.out.println(Weekday.callBasedWeekdayFunction.apply(Weekday.TUESDAY)));

        IntStream.range(0, 2).forEach(i -> System.out.println(Weekday.callBasedWeekdayFunction.apply(Weekday.MONDAY)));

    }
}

