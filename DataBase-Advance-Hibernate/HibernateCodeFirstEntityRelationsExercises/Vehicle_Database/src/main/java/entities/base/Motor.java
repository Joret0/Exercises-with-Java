package entities.base;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public abstract class Motor extends BaseVehicle{
    @Column(name = "number_of_engine")
    private int numberOfEngine;
    @Column(name = "engine_type")
    private String engineType;
    @Column(name = "tank_capacity")
    private int tankCapacity;

    public Motor() {
    }

    public Motor(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngine, String engineType, int tankCapacity) {
        super(manufacturer, model, price, maxSpeed);
        this.numberOfEngine = numberOfEngine;
        this.engineType = engineType;
        this.tankCapacity = tankCapacity;
    }

    public int getNumberOfEngine() {
        return numberOfEngine;
    }

    public void setNumberOfEngine(int numberOfEngine) {
        this.numberOfEngine = numberOfEngine;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
