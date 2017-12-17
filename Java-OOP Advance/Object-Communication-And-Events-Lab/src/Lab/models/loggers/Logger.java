package Lab.models.loggers;

import Lab.enums.LogType;
import Lab.interfaces.Handler;

public abstract class Logger implements Handler{
    private Handler successor;

    @Override
    public abstract void handle(LogType type, String message);

    @Override
    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }
}
