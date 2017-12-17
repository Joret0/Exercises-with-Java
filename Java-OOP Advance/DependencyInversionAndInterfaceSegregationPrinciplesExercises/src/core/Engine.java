package core;

import interfaces.ICommandHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Engine implements Runnable {
    private ICommandHandler commandHandler;

    public Engine(ICommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    public void run() {
        StringBuilder builder = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String input = in.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] arguments = input.split("\\\\");
                String commandResult = this.commandHandler.ExecuteCommand(arguments[0], Arrays.asList(arguments).subList(1, arguments.length));
                builder.append(commandResult).append(System.lineSeparator());
            } catch (Exception exception) {
                builder.append(exception.getMessage()).append(System.lineSeparator());
            }
        }

        if (builder.length() > 0) {
            System.out.println(builder.toString().trim());
        }
    }
}
