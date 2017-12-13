package blobs.run;

import blobs.core.GameManager;
import blobs.engine.Engine;
import blobs.utilities.InputParser;
import logger.io.ConsoleInputReader;
import logger.io.ConsoleOutputWriter;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser inputParser = new InputParser();
        GameManager gameManager = new GameManager(new LinkedHashMap<>());
        Engine engine = new Engine(inputReader, outputWriter, inputParser, gameManager);
        engine.run();
    }
}
