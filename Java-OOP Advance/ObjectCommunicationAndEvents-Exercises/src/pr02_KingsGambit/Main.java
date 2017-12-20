package pr02_KingsGambit;

import pr02_KingsGambit.engines.Engine;
import pr02_KingsGambit.utilities.InputParser;

public class Main {
    public static void main(String[] args) {
        InputParser parser = new InputParser();
        Runnable engine = new Engine(parser);
        engine.run();
    }
}
