package pr01_EventImplementation.engines;

import pr01_EventImplementation.models.Dispatcher;

import java.util.Scanner;

public class Engine implements Runnable{
    private Dispatcher dispatcher;
    private static final String TERMINATE_COMMAND = "End";

    public Engine(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (TERMINATE_COMMAND.equals(line)) {
                break;
            }
            this.dispatcher.changeName(line);
        }
    }
}
