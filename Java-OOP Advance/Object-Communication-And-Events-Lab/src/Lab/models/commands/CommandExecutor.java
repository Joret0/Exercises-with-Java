package Lab.models.commands;

import Lab.interfaces.Command;
import Lab.interfaces.Executor;

public class CommandExecutor implements Executor{
    @Override
    public void executeCommand(Command command) {
        command.execute();
    }
}
