package hell;

import hell.engine.Engine;
import hell.interfaces.*;
import hell.interpreters.CommandInterpreter;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;
import hell.repository.HeroRepository;
import hell.utils.InputParser;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository repository = new HeroRepository();
        Parser parser = new InputParser();
        Interpreter interpreter = new CommandInterpreter(repository, parser);
        Runnable runnable = new Engine(reader, writer, interpreter);

        runnable.run();
    }
}