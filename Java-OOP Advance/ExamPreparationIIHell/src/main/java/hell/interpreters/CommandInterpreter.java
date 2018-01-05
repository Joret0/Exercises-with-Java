package hell.interpreters;


import hell.annotations.InjectArgs;
import hell.interfaces.Executable;
import hell.interfaces.Interpreter;
import hell.interfaces.Parser;
import hell.interfaces.Repository;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter implements Interpreter{
    private static final String PACKAGE = "hell.commands.";
    private static final String COMMAND_SUFFIX = "Command";
    private Repository repository;
    private Parser parser;

    public CommandInterpreter(Repository repository, Parser parser) {
        this.repository = repository;
        this.parser = parser;
    }

    @Override
    public Executable interpretCommand(String line) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] params = this.parser.parseInputAsArray(line);
        /*class->ctor->newInstance*/
        Class<Executable> clazz = (Class<Executable>) Class.forName(PACKAGE + params[0] + COMMAND_SUFFIX);
        Constructor<Executable> ctor = clazz.getDeclaredConstructor(Repository.class);
        Executable executable = ctor.newInstance(this.repository);
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
