package entities.motor.ship;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CruiseShip extends Ship{
    @Column(name = "pasenger_capasity")
    private int passengerCapacity;

    public CruiseShip() {
    }

    public CruiseShip(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, String nationality, String captainName, int crewSize, int passengerCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity, nationality, captainName, crewSize);
        this.passengerCapacity = passengerCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
