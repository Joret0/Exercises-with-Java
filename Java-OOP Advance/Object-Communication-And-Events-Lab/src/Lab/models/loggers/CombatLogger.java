package Lab.models.loggers;

import Lab.enums.LogType;
import Lab.models.loggers.Logger;

public class CombatLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ATTACK || type == LogType.MAGIC) {
            System.out.println(type.name() + ": " + message);
        }
        super.passToSuccessor(type, message);
    }
}
