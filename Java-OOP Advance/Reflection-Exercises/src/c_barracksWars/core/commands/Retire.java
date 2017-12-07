package c_barracksWars.core.commands;

import c_barracksWars.annotation.Alias;
import c_barracksWars.annotation.Inject;
import c_barracksWars.contracts.Repository;

@Alias(value = "retire")
public class Retire extends Command{
    @Inject
    private Repository repository;

    public Retire(String helperParam, String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        this.repository.removeUnit(super.getData()[1]);
        return "";
    }
}
