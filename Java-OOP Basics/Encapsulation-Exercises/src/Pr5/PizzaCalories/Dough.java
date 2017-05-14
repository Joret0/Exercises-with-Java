package Pr5.PizzaCalories;


public class Dough {
    private static final int BASE_CALORIES_PER_GRAM = 2;
    private String type;
    private String backingTechnique;
    private double grams;
    private double calories;

    public Dough(String type, String backingTechnique, double grams) {
        this.setType(type);
        this.setBackingTechnique(backingTechnique);
        this.setGrams(grams);
        this.setCalories(type, backingTechnique, grams);
    }

    public double getCalories() {
        return this.calories;
    }
    private void setCalories(String type, String backingTechnique, double grams) {
        double doughCalories = 0;
        if (this.getType().toLowerCase().equals("white")) {
            doughCalories = 1.5;
        } else if (this.getType().toLowerCase().equals("wholegrain")) {
            doughCalories = 1.0;
        }
        double backingCalories = 0;
        if (this.getBackingTechnique().toLowerCase().equals("crispy")) {
            backingCalories = 0.9;
        } else if (this.getBackingTechnique().toLowerCase().equals("chewy")) {
            backingCalories = 1.1;
        } else if (this.getBackingTechnique().toLowerCase().equals("homemade")) {
            backingCalories = 1.0;
        }
        this.calories = (BASE_CALORIES_PER_GRAM * this.getGrams()) * doughCalories * backingCalories;
    }

    private String getType() {
        return this.type;
    }
    private void setType(String type) {
        if (!type.toLowerCase().equals("white") && !type.toLowerCase().equals("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.type = type;
    }
    private String getBackingTechnique() {
        return this.backingTechnique;
    }
    private void setBackingTechnique(String backingTechnique) {
        this.backingTechnique = backingTechnique;
    }
    private double getGrams() {
        return this.grams;
    }
    private void setGrams(double grams) {
        if (grams < 1 || grams > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.grams = grams;
    }
}
