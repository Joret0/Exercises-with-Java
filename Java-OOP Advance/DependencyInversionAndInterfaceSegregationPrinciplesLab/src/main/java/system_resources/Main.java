package system_resources;

import system_resources.implementations.ConsoleOutputWriter;
import system_resources.implementations.CurrentTime;
import system_resources.models.GreetingClock;

public class Main {
    public static void main(String[] args) {
        GreetingClock clock = new GreetingClock(new CurrentTime(), new ConsoleOutputWriter());
        clock.greeting();
    }
}
