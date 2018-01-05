package hell.commands;

import hell.interfaces.Repository;

public class QuitCommand extends BaseCommand{
    public QuitCommand(Repository repository) {
        super(repository);
    }

    @Override
    public String execute() throws IllegalAccessException {
        return super.getManager().quitCommand();
    }
}
