package application.model;

import java.util.Random;

public class Discount {
    public static int getRandomDiscount() {
      int[] discounts = new int[]{
        0, 5, 10, 15, 20, 30, 40, 50
      };
        Random random = new Random();
        int num = random.nextInt(8);
        return discounts[num];
    }
}
