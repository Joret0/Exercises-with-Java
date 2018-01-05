package app.commands;

import app.manager.Manager;
import app.waste_disposal.annotations.InjectArgs;

public class ChangeManagementRequirementCommand extends BaseCommand{
    @InjectArgs
    private String[] params;

    public ChangeManagementRequirementCommand(Manager manager) {
        super(manager);
    }

    @Override
    public String execute() {
        return super.getManager().changeManagementRequirement(Double.parseDouble(this.params[1]), Double.parseDouble(this.params[2]), this.params[3]);
    }
}
