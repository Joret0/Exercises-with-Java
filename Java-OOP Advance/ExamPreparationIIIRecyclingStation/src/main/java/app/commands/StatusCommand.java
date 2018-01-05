package app.commands;

import app.manager.Manager;

public class StatusCommand extends BaseCommand{
    public StatusCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute() {
        return super.getManager().statusCommand();
    }
}
