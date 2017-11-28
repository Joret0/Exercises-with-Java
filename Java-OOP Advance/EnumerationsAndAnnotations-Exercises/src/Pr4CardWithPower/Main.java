package Pr4CardWithPower;

import Pr4CardWithPower.CardGame.core.GameManager;
import Pr4CardWithPower.CardGame.engine.Engine;
import Pr4CardWithPower.CardGame.io.ConsoleInputReader;
import Pr4CardWithPower.CardGame.utils.InputParser;

public class Main {
    public static void main(String[] args) {
        GameManager manager = new GameManager();
        ConsoleInputReader inputReader = new ConsoleInputReader();
        InputParser parser = new InputParser();
        Engine engine = new Engine(manager, inputReader, parser);
        engine.run();
    }
}
