package hell.commands;

import hell.annotations.InjectArgs;
import hell.interfaces.Repository;

public class InspectCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public InspectCommand(Repository repository) {
        super(repository);
    }

    @Override
    public String execute() throws IllegalAccessException {
        return super.getManager().inspectCommand(params[1]);
    }
}
