package entities.motor.train;

import javax.persistence.*;

@Entity
public class Locomotive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locomotive_id")
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "power")
    private int power;

    public Locomotive() {
    }

    public Locomotive(String model, int power) {
        this.model = model;
        this.power = power;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
