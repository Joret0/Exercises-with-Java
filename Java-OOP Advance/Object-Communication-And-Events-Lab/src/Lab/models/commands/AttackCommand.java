package Lab.models.commands;

import Lab.interfaces.Attacker;
import Lab.interfaces.Command;

public class AttackCommand implements Command{
    private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        this.attacker.attack();
    }
}
