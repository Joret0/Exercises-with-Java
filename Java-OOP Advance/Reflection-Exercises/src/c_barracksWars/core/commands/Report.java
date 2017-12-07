package c_barracksWars.core.commands;

import c_barracksWars.annotation.Alias;
import c_barracksWars.annotation.Inject;
import c_barracksWars.contracts.Repository;

@Alias(value = "report")
public class Report extends Command{
    @Inject
    private Repository repository;

    public Report(String helperParam, String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
