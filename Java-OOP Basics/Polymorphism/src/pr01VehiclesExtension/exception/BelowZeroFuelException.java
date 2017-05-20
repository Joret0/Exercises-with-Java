package pr01VehiclesExtension.exception;

public class BelowZeroFuelException extends FuelException {

    public BelowZeroFuelException() {
        super("Fuel must be positive number");
    }
}
