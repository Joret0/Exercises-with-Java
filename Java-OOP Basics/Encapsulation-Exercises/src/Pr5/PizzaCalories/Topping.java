package Pr5.PizzaCalories;


public class Topping {
    private static final int BASE_CALORIES_PER_GRAM = 2;
    private String type;
    private double grams;
    private double calories;

    public Topping(String type, double grams) {
        this.setType(type);
        this.setGrams(grams);
        this.setCalories(type, grams);
    }

    private String getType() {
        return this.type;
    }
    private void setType(String type) {
        if (!type.toLowerCase().equals("meat") && !type.toLowerCase().equals("veggies") && !type.toLowerCase().equals("cheese") && !type.toLowerCase().equals("sauce")) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }
    private double getGrams() {
        return this.grams;
    }
    private void setGrams(double grams) {
        if (grams < 1 || grams > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.getType()));
        }
        this.grams = grams;
    }
    public double getCalories() {
        return this.calories;
    }
    private void setCalories(String type, double grams) {
        double calorieIndex = 0;
        switch (type.toLowerCase()) {
            case "meat":
                calorieIndex = 1.2;
                break;
            case "veggies":
                calorieIndex = 0.8;
                break;
            case "cheese":
                calorieIndex = 1.1;
                break;
            case "sauce":
                calorieIndex = 0.9;
                break;
        }
        this.calories = BASE_CALORIES_PER_GRAM * grams * calorieIndex;
    }
}
