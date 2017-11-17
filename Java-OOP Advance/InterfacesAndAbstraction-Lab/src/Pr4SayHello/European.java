package Pr4SayHello;


public class European implements Person{

    private String name;

    European(String name) {
        this.setName(name);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return String.format("Hello");
    }
}
