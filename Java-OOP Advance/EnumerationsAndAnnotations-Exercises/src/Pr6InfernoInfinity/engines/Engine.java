package Pr6InfernoInfinity.engines;

import Pr6InfernoInfinity.core.GameManager;
import Pr6InfernoInfinity.io.ConsoleInputReader;
import Pr6InfernoInfinity.io.ConsoleOutputWriter;
import Pr6InfernoInfinity.utilities.Constants;
import Pr6InfernoInfinity.utilities.InputParser;

import java.util.List;

public class Engine {
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

    public void run() {
        String inputLine;

        while (!(inputLine = this.inputReader.readLine()).equals(Constants.INPUT_TERMINATING_COMMAND)) {
            List<String> commandParams = this.inputParser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);

        switch (command) {
            case "Create":
                this.manager.create(commandParams.get(0), commandParams.get(1));
                break;
            case "Add":
                this.manager.add(commandParams.get(0), Integer.parseInt(commandParams.get(1)), commandParams.get(2));
                break;
            case "Remove":
                this.manager.remove(commandParams.get(0), Integer.parseInt(commandParams.get(1)));
                break;
            case "Compare":
                this.outputWriter.writeLine(this.manager.compare(commandParams.get(0), commandParams.get(1)));
                break;

            case "Author":
                this.outputWriter.writeLine(this.manager.printAuthor());
                break;
            case "Revision":
                this.outputWriter.writeLine(this.manager.printRevision());
                break;
            case "Description":
                this.outputWriter.writeLine(this.manager.printDescription());
                break;
            case "Reviewers":
                this.outputWriter.writeLine(this.manager.printReviewers());
                break;

            case "Print":
                this.outputWriter.writeLine(this.manager.print(commandParams.get(0)));
                break;
        }
    }
}
