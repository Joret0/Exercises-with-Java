package app.commands;

import app.manager.Manager;

public abstract class BaseCommand implements Executable{
    private Manager manager;

    protected BaseCommand(Manager manager) {
        this.manager = manager;
    }

    protected Manager getManager() {
        return manager;
    }
}
