package pr01VehiclesExtension.exception;

public class CannotFitTankException extends FuelException {

    public CannotFitTankException() {
        super("Cannot fit fuel in tank");
    }
}
