package blobs.engine;

import blobs.core.GameManager;
import blobs.interfaces.IEngine;
import blobs.utilities.Constants;
import blobs.utilities.InputParser;
import logger.io.ConsoleInputReader;
import logger.io.ConsoleOutputWriter;

import java.util.List;

public class Engine implements IEngine{
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser inputParser;
    private GameManager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser inputParser, GameManager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.inputParser = inputParser;
        this.manager = manager;
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "create":
                String name = commandParams.remove(0);
                int health = Integer.parseInt(commandParams.remove(0));
                int damage = Integer.parseInt(commandParams.remove(0));
                String behavior = commandParams.remove(0);
                String attack = commandParams.remove(0);

                this.manager.create(name, health, damage, behavior, attack);
                break;
            case "attack":
                String attackerName = commandParams.remove(0);
                String targetName = commandParams.remove(0);

                this.outputWriter.writeLine(this.manager.attack(attackerName, targetName));
                break;
            case "pass":
                this.manager.pass();
                break;
            case "status":
                this.outputWriter.writeLine(this.manager.status());
                break;
            case "report-events":
                this.manager.enableReportEvents();
                break;
        }
    }

    @Override
    public void run() {
        String inputLine;

        while (!(inputLine = this.inputReader.readLine()).equals(Constants.INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }
}
