package Pr6InfernoInfinity;

import Pr6InfernoInfinity.core.GameManager;
import Pr6InfernoInfinity.engines.Engine;
import Pr6InfernoInfinity.io.ConsoleInputReader;
import Pr6InfernoInfinity.io.ConsoleOutputWriter;
import Pr6InfernoInfinity.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        GameManager gameManager = new GameManager();
        Engine engine = new Engine(inputReader, outputWriter, inputParser, gameManager);

        engine.run();

    }
}
