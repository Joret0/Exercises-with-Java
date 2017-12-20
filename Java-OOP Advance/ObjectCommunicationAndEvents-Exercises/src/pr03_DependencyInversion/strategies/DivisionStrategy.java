package pr03_DependencyInversion.strategies;

public class DivisionStrategy implements Strategy{
    private static DivisionStrategy additionStrategy = new DivisionStrategy();

    public static DivisionStrategy getSingleInstance() {
        return additionStrategy;
    }

    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
