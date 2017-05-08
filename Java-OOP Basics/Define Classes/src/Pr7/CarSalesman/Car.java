package Pr7.CarSalesman;


public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine, String weight, String color) {
        this.model = model;
        this.engine = engine;
        if (weight == null) {
            this.weight = "n/a";
        } else {
            this.weight = weight;
        }
        if (color == null) {
            this.color = "n/a";
        } else {
            this.color = color;
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s:%n", this.model));
        builder.append(String.format(" %s:%n", this.engine.getModel()));
        builder.append(String.format("\tPower: %d%n", this.engine.getPower()));
        builder.append(String.format("\tDisplacement: %s%n", this.engine.getDisplacement()));
        builder.append(String.format("\tEfficiency: %s%n", this.engine.getEfficiency()));
        builder.append(String.format(" Weight: %s%n", this.weight));
        builder.append(String.format(" Color: %s", this.color));

        return builder.toString();
    }
}
