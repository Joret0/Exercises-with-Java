package Pr5SayHelloExtended;

public class European extends BasePerson implements Person{
    European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Hello");
    }
}
