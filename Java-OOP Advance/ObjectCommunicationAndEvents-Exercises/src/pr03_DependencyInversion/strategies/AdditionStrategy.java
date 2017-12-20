package pr03_DependencyInversion.strategies;

public class AdditionStrategy implements Strategy{
    private static AdditionStrategy additionStrategy = new AdditionStrategy();

    public static AdditionStrategy getSingleInstance() {
        return additionStrategy;
    }

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }
}
