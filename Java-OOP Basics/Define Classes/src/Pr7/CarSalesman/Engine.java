package Pr7.CarSalesman;


public class Engine {
    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine(String model, int power, String displacement, String efficiency) {
        this.model = model;
        this.power = power;
        if (displacement == null) {
            this.displacement = "n/a";
        } else {
            this.displacement = displacement;
        }
        if (efficiency == null) {
            this.efficiency = "n/a";
        } else {
            this.efficiency = efficiency;
        }
    }

    public String getModel() {
        return this.model;
    }

    public int getPower() {
        return this.power;
    }

    public String getDisplacement() {
        return this.displacement;
    }

    public String getEfficiency() {
        return this.efficiency;
    }
}
