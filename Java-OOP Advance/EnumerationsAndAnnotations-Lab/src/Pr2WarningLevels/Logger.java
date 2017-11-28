package Pr2WarningLevels;

import java.util.ArrayList;
import java.util.List;

class Logger {
    private List<Message> messages;
    private Importance importance;

    Logger(Importance importance) {
        this.messages = new ArrayList<>();
        this.importance = importance;
    }

    void receiveMessage(Message message) {
        if (message.getImportance().getPriority() >= this.importance.getPriority()) {
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages() {
        return this.messages;
    }
}
