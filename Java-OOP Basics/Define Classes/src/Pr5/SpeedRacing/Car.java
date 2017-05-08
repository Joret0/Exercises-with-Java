package Pr5.SpeedRacing;


public class Car {
    private String model;
    private double fuel;
    private double cost;
    private int distance;

    public Car(String model, double fuel, double cost){
        this.model = model;
        this.fuel = fuel;
        this.cost = cost;
        this.distance = 0;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuel() {
        return this.fuel;
    }
    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public Double getCost() {
        return this.cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getDistance() {
        return this.distance;
    }
    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void drive(int kms){
        double fuelNeeded = kms * this.cost;
        if (fuelNeeded > this.fuel) {
            System.out.println("Insufficient fuel for the drive");
        } else {
            this.fuel = this.fuel - fuelNeeded;
            this.distance += kms;
        }
    }

    public String toString() {
        return String.format("%s %.2f %d", this.getModel(), this.getFuel(), this.getDistance());
    }
}
