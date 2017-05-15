package Pr4.FragileBaseClass;


public class Main {
    public static void main(String[] args) {

        Predator predator = new Predator();
        predator.feed(new Food());
        predator.feedAll(new Food[] {new Food(), new Food(), new Food()});
        System.out.println(predator.getHealth());
    }
}
