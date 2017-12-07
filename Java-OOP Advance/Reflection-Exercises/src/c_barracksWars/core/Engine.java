package c_barracksWars.core;

import c_barracksWars.contracts.*;
import c_barracksWars.contracts.Runnable;
import c_barracksWars.core.commands.CommandInterpreter;
import c_barracksWars.io.ConsoleOutputWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable{
    private static final String COMMANDS_PATH = "src/c_barracksWars/core/commands";
    private static final String COMMANDS_PACKAGE = "c_barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    private ICommandInterpreter interpreter;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.interpreter = new CommandInterpreter(repository, unitFactory);
    }

    @Override
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        while (true) {
            String[] data = reader.readLine().split("\\s+");
            String commandName = data[0];
            Executable executable = this.interpreter.interpretCommand(data, commandName);
            String execute = executable.execute();
            ConsoleOutputWriter.writeLine(execute);

            if (execute.equals("fight")) {
                break;
            }
        }

    }
}
