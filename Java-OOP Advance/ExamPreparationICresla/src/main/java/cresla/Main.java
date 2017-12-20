package cresla;

import cresla.interfaces.InputReader;
import cresla.interfaces.Manager;
import cresla.interfaces.OutputWriter;
import cresla.io.Reader;
import cresla.io.Writer;
import cresla.manager.ManagerImpl;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Manager manager = new ManagerImpl();
        OutputWriter writer = new Writer();
        InputReader reader = new Reader();

        whileLoop:
        while (true) {
            List<String> commandTokens = Arrays.asList(reader.readLine().split(" "));

            switch (commandTokens.get(0)) {
                case "Reactor":
                    writer.write(manager.reactorCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                case "Module":
                    writer.writeLine(manager.moduleCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                case "Report":
                    writer.writeLine(manager.reportCommand(commandTokens.subList(1, commandTokens.size())));
                    break;
                    default:
                        writer.writeLine(manager.exitCommand(commandTokens));
                        break whileLoop;
            }
        }
    }
}
