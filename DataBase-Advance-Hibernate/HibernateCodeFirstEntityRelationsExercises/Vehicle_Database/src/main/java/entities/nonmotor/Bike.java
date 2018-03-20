package entities.nonmotor;

import entities.base.NonMotor;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Bike extends NonMotor{
    @Column(name = "shift_count")
    private int shiftCount;
    @Column(name = "color")
    private String color;

    public Bike() {
    }

    public Bike(int shiftCount, String color) {
        this.shiftCount = shiftCount;
        this.color = color;
    }

    public Bike(String manufacturer, String model, BigDecimal price, int maxSpeed, int shiftCount, String color) {
        super(manufacturer, model, price, maxSpeed);
        this.shiftCount = shiftCount;
        this.color = color;
    }

    public int getShiftCount() {
        return shiftCount;
    }

    public void setShiftCount(int shiftCount) {
        this.shiftCount = shiftCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
