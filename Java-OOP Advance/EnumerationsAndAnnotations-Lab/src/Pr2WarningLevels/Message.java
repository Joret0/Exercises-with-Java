package Pr2WarningLevels;

class Message {

    private String message;
    private Importance importance;

    Message(String message, Importance importance) {
        this.message = message;
        this.importance = importance;
    }

    Importance getImportance() {
        return this.importance;
    }

    String getMessage() {
        return this.message;
    }
}
