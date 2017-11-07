package Pr6Animals;

public class Cat extends Animal{

    Cat(String name, String age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String produceSound() {
        return "MiauMiau";
    }
}
