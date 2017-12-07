package c_barracksWars.core.commands;

import c_barracksWars.annotation.Alias;
import c_barracksWars.annotation.Inject;
import c_barracksWars.contracts.Executable;
import c_barracksWars.contracts.ICommandInterpreter;
import c_barracksWars.contracts.Repository;
import c_barracksWars.contracts.UnitFactory;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class CommandInterpreter implements ICommandInterpreter{
    private static final String COMMANDS_PATH = "src/c_barracksWars/core/commands";
    private static final String COMMANDS_PACKAGE = "c_barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreter(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    private void injectDependencies(Executable executable, Class<Executable> exeClass) throws ReflectiveOperationException {
        Field[] exeFields = exeClass.getDeclaredFields();
        for (Field fieldToSet : exeFields) {
            if (!fieldToSet.isAnnotationPresent(Inject.class)) {
                continue;
            }
            fieldToSet.setAccessible(true);

            Field[] theseFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisField : theseFields) {
                if (!thisField.getType().equals(fieldToSet.getType())) {
                    continue;
                }
                thisField.setAccessible(true);
                fieldToSet.set(executable, thisField.get(this));
            }
        }
    }

    @Override
    public Executable interpretCommand(String[] data, String command) {
        File commandsFolder = new File(COMMANDS_PATH);
        Executable executable = null;

        for (File file : commandsFolder.listFiles()) {
            if (!file.isFile() || !file.getName().endsWith(".java")) {
                continue;
            }
            try {
                String className = file.getName()
                        .substring(0, file.getName().lastIndexOf('.'));
                Class<Executable> exeClass = (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);

                if (!exeClass.isAnnotationPresent(Alias.class)) {
                    continue;
                }
                Alias alias = exeClass.getAnnotation(Alias.class);
                String value = alias.value();
                if (!value.equalsIgnoreCase(command)) {
                    continue;
                }

                Constructor exeCtor = exeClass.getConstructor(String.class, String[].class);
                executable = (Executable) exeCtor.newInstance(command, data);
                this.injectDependencies(executable, exeClass);

            } catch (ReflectiveOperationException rfe) {
                rfe.printStackTrace();
            }
        }

        return executable;
    }
}
