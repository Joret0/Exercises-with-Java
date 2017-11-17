package Pr5SayHelloExtended;

public class Chinese extends BasePerson implements Person{

    Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Djydjybydjy");
    }
}
