//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import lambda.LambdaSandbox;
public class Main {
    public static void main(String[] args) {
        LambdaSandbox lambdaSandbox = new LambdaSandbox();

        lambdaSandbox.runnableTest();
        lambdaSandbox.r.run();

        lambdaSandbox.intConsumer.accept(5);

        lambdaSandbox.randomSupplier.get();
    }
}