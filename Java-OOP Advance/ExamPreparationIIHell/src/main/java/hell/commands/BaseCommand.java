package hell.commands;

import hell.interfaces.Executable;
import hell.interfaces.Repository;

public abstract class BaseCommand implements Executable{
    private Repository repository;

    protected BaseCommand(Repository repository) {
        this.repository = repository;
    }

    protected Repository getManager() {
        return this.repository;
    }
}
