package Pr5SayHelloExtended;

public class Bulgarian extends BasePerson implements Person{

    Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return String.format("Здравей");
    }
}
