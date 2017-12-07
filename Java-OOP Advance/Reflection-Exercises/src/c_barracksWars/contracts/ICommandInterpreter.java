package c_barracksWars.contracts;

public interface ICommandInterpreter {

    Executable interpretCommand(String[] data, String commandName);
}
