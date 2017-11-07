package Pr6Animals;

public class Kitten extends Cat{
    Kitten(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "Miau";
    }
}
