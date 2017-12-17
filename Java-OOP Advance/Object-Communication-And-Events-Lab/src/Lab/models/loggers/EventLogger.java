package Lab.models.loggers;

import Lab.enums.LogType;
import Lab.models.loggers.Logger;

public class EventLogger extends Logger {
    @Override
    public void handle(LogType type, String message) {
        if (type == LogType.ERROR) {
            System.out.println(String.format("%s: %s", type.name(), message));
        }
        super.passToSuccessor(type, message);
    }
}
