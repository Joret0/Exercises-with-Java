package Lab;

import Lab.enums.LogType;
import Lab.interfaces.*;
import Lab.models.Dragon;
import Lab.models.Group;
import Lab.models.Warrior;
import Lab.models.commands.*;
import Lab.models.loggers.CombatLogger;
import Lab.models.loggers.EventLogger;
import Lab.models.loggers.Logger;

public class Main {
    public static void main(String[] args) {
        Logger combatLog = new CombatLogger();
        Logger errorLog = new EventLogger();

        combatLog.setSuccessor(errorLog);

        AttackGroup group = new Group();
        Attacker warrior = new Warrior("Warrior", 10, combatLog);
        Attacker elderWarrior = new Warrior("ElderWarrior", 13, combatLog);
        group.addMember(warrior);
        group.addMember(elderWarrior);

        Target dragon = new Dragon("Dragon", 100, 25, combatLog);

        Executor executor = new CommandExecutor();

        Command groupTarget = new GroupTargetCommand(group, dragon);
        Command groupAttack = new GroupAttackCommand(group);

        Command target = new TargetCommand(warrior, dragon);
        Command attack = new AttackCommand(warrior);

        combatLog.handle(LogType.ATTACK, "some attack");
        combatLog.handle(LogType.ERROR, "some error");
        combatLog.handle(LogType.EVENT, "some event");
    }
}
