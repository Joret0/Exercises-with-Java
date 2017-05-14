package Pr3.AnimalFarm;

public class Chicken {
    private static final int MIN_AGE = 0;
    private static final int MAX_AGE = 15;

    private String name;
    private int age;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }
    public String getName() {
        return this.name;
    }
    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    private void setAge(int age) {
        if (age < MIN_AGE || age > MAX_AGE) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }
    public double getProductPerDay() {
        return this.calculateProductPerDay();
    }
    private double calculateProductPerDay() {
        switch (this.getAge()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return 2;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                return 1;
            case 13:
            case 14:
            case 15:
                return 0.75;
            default:
                return 1;
        }
    }
}
