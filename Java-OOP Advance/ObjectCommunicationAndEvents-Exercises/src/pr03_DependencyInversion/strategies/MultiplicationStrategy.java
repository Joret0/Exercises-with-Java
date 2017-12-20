package pr03_DependencyInversion.strategies;

public class MultiplicationStrategy implements Strategy{
    private static MultiplicationStrategy additionStrategy = new MultiplicationStrategy();

    public static MultiplicationStrategy getSingleInstance() {
        return additionStrategy;
    }

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
