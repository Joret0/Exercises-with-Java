package app;

import app.engine.Engine;
import app.interpreters.CommandInterpreter;
import app.interpreters.Interpreter;
import app.io.ConsoleInputReader;
import app.io.ConsoleOutputWriter;
import app.io.InputReader;
import app.io.OutputWriter;
import app.manager.Manager;
import app.manager.WasteManager;
import app.utils.InputParser;
import app.utils.Parser;
import app.waste_disposal.DefaultGarbageProcessor;
import app.waste_disposal.contracts.GarbageProcessor;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        GarbageProcessor processor = new DefaultGarbageProcessor();
        Manager manager = new WasteManager(processor);
        Parser parser = new InputParser();
        Interpreter interpreter = new CommandInterpreter(manager, parser);
        Runnable runnable = new Engine(reader, writer, interpreter);

        runnable.run();
    }
}
