package lambda;

import java.util.function.*;

public class LambdaSandbox {

    ///  Runnable -> () -> void | Takes nothing and do nothing as well
    public void runnableTest() {
        System.out.println("Runnable Test Traditional");
    }

    public Runnable r = () -> System.out.println("Runnable Testing Lambda");


    public <T> void consumerTest(T input)  {
        System.out.println("Entered " + input + " traditionally");
    }

    public Consumer<String> c = (input) -> System.out.println("Entered " + input + " traditionally");


    public void intConsumerTest(int input) {
        System.out.println(input);
    }

    public IntConsumer intConsumer = System.out::println;

    public Supplier<Double> randomSupplier = () -> Math.random();

    public Function<String, Integer> lengthCalculator = String::length;

    public IntFunction<String> aGenerator = "a"::repeat;


}


