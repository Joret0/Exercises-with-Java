package app.commands;

import app.factories.WasteFactory;
import app.manager.Manager;
import app.waste_disposal.annotations.InjectArgs;
import app.waste_disposal.contracts.Waste;

public class ProcessGarbageCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public ProcessGarbageCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute() {
        Waste waste = WasteFactory.create(params[1], Double.parseDouble(params[2]), Double.parseDouble(params[3]), params[4]);
        return super.getManager().processGarbageCommand(waste);
    }
}
