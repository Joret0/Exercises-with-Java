package Lab.models.commands;

import Lab.interfaces.Attacker;
import Lab.interfaces.Command;
import Lab.interfaces.Target;

public class TargetCommand implements Command{
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
