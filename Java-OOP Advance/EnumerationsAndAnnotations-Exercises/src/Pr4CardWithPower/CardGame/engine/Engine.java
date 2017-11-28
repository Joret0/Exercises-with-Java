package Pr4CardWithPower.CardGame.engine;

import Pr4CardWithPower.CardGame.core.GameManager;
import Pr4CardWithPower.CardGame.io.ConsoleInputReader;
import Pr4CardWithPower.CardGame.utils.InputParser;

public class Engine {
    private GameManager manager;
    private ConsoleInputReader inputReader;
    private InputParser parser;

    public Engine(GameManager manager, ConsoleInputReader inputReader, InputParser parser) {
        this.manager = manager;
        this.inputReader = inputReader;
        this.parser = parser;
    }

    public void run() {
        this.manager.addFirstPlayer(inputReader.readLine());
        this.manager.addSecondPlayer(inputReader.readLine());

        while (true) {
            String[] suitRank = parser.parseInputAsArray(inputReader.readLine());
            if (this.manager.addCardToPlayer(suitRank[0], suitRank[1])) {
                this.manager.printWinner();
                break;
            }
        }

    }
}
