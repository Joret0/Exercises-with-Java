package Pr6Animals;

public class Dog  extends Animal{
    Dog(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "BauBau";
    }
}
