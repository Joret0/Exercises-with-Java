package Lab.models.commands;

import Lab.interfaces.AttackGroup;
import Lab.interfaces.Command;
import Lab.interfaces.Target;

public class GroupTargetCommand implements Command{

    private AttackGroup attackGroup;
    private Target target;

    public GroupTargetCommand(AttackGroup attacker, Target target) {
        this.attackGroup = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attackGroup.groupTarget(this.target);
    }
}
