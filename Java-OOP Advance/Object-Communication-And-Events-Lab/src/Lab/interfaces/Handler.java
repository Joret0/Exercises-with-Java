package Lab.interfaces;

import Lab.enums.LogType;

public interface Handler {
    void handle(LogType type, String message);
    void setSuccessor(Handler handler);
}
