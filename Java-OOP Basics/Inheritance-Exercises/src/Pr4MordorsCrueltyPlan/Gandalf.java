package Pr4MordorsCrueltyPlan;

import java.util.Collections;
import java.util.List;

public class Gandalf {

    private List<Food> foodList;
    private int pointOfHappiness;
    private String mood;

    Gandalf(List<Food> foodList, int pointOfHappiness, String mood) {
        this.setFoodList(foodList);
        this.setPointOfHappiness(pointOfHappiness);
        this.setMood(mood);
    }

    public List<Food> getFoodList() {
        return Collections.unmodifiableList(this.foodList);
    }

    private void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    private int getPointOfHappiness() {
        return this.pointOfHappiness;
    }

    private void setPointOfHappiness(int pointOfHappiness) {
        for (Food food : foodList) {
            switch (food.getName()) {
                case "cram":
                    pointOfHappiness += 2;
                    break;
                case "lembas":
                    pointOfHappiness += 3;
                    break;
                case "apple":
                    pointOfHappiness++;
                    break;
                case "melon":
                    pointOfHappiness++;
                    break;
                case "honeycake":
                    pointOfHappiness += 5;
                    break;
                case "mushrooms":
                    pointOfHappiness -= 10;
                    break;
                default:
                    pointOfHappiness--;
                    break;
            }
            this.pointOfHappiness = pointOfHappiness;
        }
        this.pointOfHappiness = pointOfHappiness;
    }

    private String getMood() {
        return this.mood;
    }

    private void setMood(String mood) {
        if (this.getPointOfHappiness() < -5) {
            mood = "Angry";
        } else if (this.getPointOfHappiness() >= -5 && this.getPointOfHappiness() < 1) {
            mood = "Sad";
        } else if (this.getPointOfHappiness() > 0 && this.getPointOfHappiness() <= 15) {
            mood = "Happy";
        } else if (this.getPointOfHappiness() > 15) {
            mood = "JavaScript";
        }
        this.mood = mood;
    }

    @Override
    public String toString() {
        return String.format("%d%n%s", this.getPointOfHappiness(), this.getMood());
    }
}
