package pr03_DependencyInversion;

import pr03_DependencyInversion.calculator.Calculator;
import pr03_DependencyInversion.calculator.PrimitiveCalculator;
import pr03_DependencyInversion.engine.Engine;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new PrimitiveCalculator();
        Runnable runnable = new Engine(calculator);
        runnable.run();
    }
}
