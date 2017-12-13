package logger.run;

import logger.commands.CommandInterpreter;
import logger.core.Controller;
import logger.factory.appenderFactories.AbstractAppenderFactory;
import logger.factory.layoutFactories.AbstractLayoutFactory;
import logger.interfaces.*;
import logger.io.ConsoleInputReader;
import logger.repository.Repository;
import logger.utils.InputParser;

public class Main {
    public static void main(String[] args) {
        IConsoleInputReader consoleInputReader = new ConsoleInputReader();
        IInputParser inputParser = new InputParser();
        IAppenderFactory appenderFactory = new AbstractAppenderFactory();
        ILayoutFactory layoutFactory = new AbstractLayoutFactory();
        IRepository repository = new Repository();
        CommandInterpreter commandInterpreter = new CommandInterpreter(appenderFactory, layoutFactory);
        IController controller = new Controller(consoleInputReader, inputParser, commandInterpreter, repository);
        controller.run();
    }
}
