package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class StreamsSandbox {
    public static void main(String[] strings) {
        /*
        int len = strings.length;
        for(int i = 0; i < len; i++) {
            System.out.println(strings[len - i - 1].length());
        }
        */

        /*
        IntStream.range(0, strings.length)
                .mapToObj(i -> strings[strings.length - i - 1])
                .map(String::length)
                .forEach(System.out::println);

         */

        int len = strings.length;
        int sum = Arrays.stream(strings).map(StreamsSandbox::parseInt)
                .filter(integer -> integer >= 8 && integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);


    }


    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static List<Integer> primeReturner(int N) {
        int count = 0;
        int num = 2;
        List<Integer> primeNumbers = new ArrayList<>();

        while (count != N) {
            boolean prime = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                count++;
                primeNumbers.add(num);
            }
            num++;
        }

        return primeNumbers;
    }
}
