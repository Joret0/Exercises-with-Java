package hell.engine;

import hell.interfaces.Executable;
import hell.interfaces.InputReader;
import hell.interfaces.Interpreter;
import hell.interfaces.OutputWriter;

import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable{
    private static final String INPUT_TERMINATING_COMMAND = "Quit";
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
                Executable executable = this.interpreter.interpretCommand(line);
                String executeResult = executable.execute();
                this.outputWriter.writeLine(executeResult);
                if (INPUT_TERMINATING_COMMAND.equals(line)) break;
                line = inputReader.readLine();
            } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
