package app.engine;

import app.commands.Executable;
import app.interpreters.Interpreter;
import app.io.InputReader;
import app.io.OutputWriter;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable{
    private static final String INPUT_TERMINATING_COMMAND = "TimeToRecycle";
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Interpreter interpreter;

    public Engine(InputReader inputReader, OutputWriter outputWriter, Interpreter interpreter) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        String line = inputReader.readLine();
        while (true) {
            try {
                if (INPUT_TERMINATING_COMMAND.equals(line)) break;
                Executable executable = this.interpreter.interpretCommand(line);
                String executeResult = executable.execute();
                this.outputWriter.writeLine(executeResult);
                line = inputReader.readLine();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
