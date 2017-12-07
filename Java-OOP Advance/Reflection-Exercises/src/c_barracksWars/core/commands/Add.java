package c_barracksWars.core.commands;

import c_barracksWars.annotation.Alias;
import c_barracksWars.annotation.Inject;
import c_barracksWars.contracts.Repository;
import c_barracksWars.contracts.Unit;
import c_barracksWars.contracts.UnitFactory;

@Alias(value = "add")
public class Add extends Command{
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add(String helperParam, String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit createdUnit = this.unitFactory.createUnit(unitType);
        this.repository.addUnit(createdUnit);
        return unitType + " added!";
    }
}
