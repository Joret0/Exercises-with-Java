package entities.motor.ship;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class CargoShip extends Ship{
    @Column(name = "max_load_kg")
    private long maxLoadKg;

    public CargoShip() {
    }

    public CargoShip(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity, String nationality, String captainName, int crewSize, long maxLoadKg) {
        super(manufacturer, model, price, maxSpeed, numberOfEngine, engineType, tankCapacity, nationality, captainName, crewSize);
        this.maxLoadKg = maxLoadKg;
    }

    public long getMaxLoadKg() {
        return maxLoadKg;
    }

    public void setMaxLoadKg(long maxLoadKg) {
        this.maxLoadKg = maxLoadKg;
    }
}
