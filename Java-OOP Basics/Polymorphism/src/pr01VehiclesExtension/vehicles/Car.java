package pr01VehiclesExtension.vehicles;

import pr01VehiclesExtension.exception.CannotFitTankException;

public class Car extends Vehicle {
    public Car(double fuelQuantity, double littersPerKm, double tankCapacity) {
        super(fuelQuantity, littersPerKm, tankCapacity);
    }

    @Override
    public void drive(double distance, double extraLiters) {
        super.drive(distance, extraLiters);
    }

    @Override
    public void refuel(double fuel) {
        if (this.getFuelQuantity() + fuel > this.getTankCapacity()) {
            throw new CannotFitTankException();
        }
        super.refuel(fuel);
    }
}
