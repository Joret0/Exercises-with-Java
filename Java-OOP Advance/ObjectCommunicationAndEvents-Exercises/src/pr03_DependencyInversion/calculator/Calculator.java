package pr03_DependencyInversion.calculator;

import pr03_DependencyInversion.strategies.Strategy;

public interface Calculator {
    void changeStrategy(Strategy strategy);

    int performCalculation(int firstOperand, int secondOperand);
}
