package app.interpreters;

import app.commands.Executable;
import app.manager.Manager;
import app.utils.Parser;
import app.waste_disposal.annotations.InjectArgs;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter{
    private static final String PACKAGE = "app.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private Manager manager;
    private Parser parser;

    public CommandInterpreter(Manager manager, Parser parser) {
        this.manager = manager;
        this.parser = parser;
    }

    @Override
    public app.commands.Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] params = this.parser.parseInputAsArray(line);
        /*class->ctor->newInstance*/
        Class<Executable> clazz = (Class<Executable>) Class.forName(PACKAGE + params[0] + COMMAND_SUFFIX);
        Constructor<Executable> ctor = clazz.getDeclaredConstructor(Manager.class);
        Executable executable = ctor.newInstance(this.manager);
        this.injectDependencies(executable, params);
        return executable;
    }

    private void injectDependencies(Executable executable, String[] params) throws IllegalAccessException {
        for (Field field : executable.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(InjectArgs.class)) {
                field.setAccessible(true);
                field.set(executable, params);
                break;
            }
        }
    }
}
