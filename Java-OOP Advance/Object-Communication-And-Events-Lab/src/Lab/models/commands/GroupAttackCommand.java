package Lab.models.commands;

import Lab.interfaces.AttackGroup;
import Lab.interfaces.Command;

public class GroupAttackCommand implements Command{
    private AttackGroup attackGroup;

    public GroupAttackCommand(AttackGroup attacker) {
        this.attackGroup = attacker;
    }

    @Override
    public void execute() {
        this.attackGroup.groupAttack();
    }
}
