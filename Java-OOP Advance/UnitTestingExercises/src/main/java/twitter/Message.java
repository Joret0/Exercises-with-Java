package twitter;

import java.util.List;

public class Message implements Tweet{
    private List<String> messages;

    public Message(List<String> messages) {
        this.messages = messages;
    }
    @Override
    public String retrieveMessage() {
        return this.messages.get(new IRandom.Random().nextInt(messages.size()));
    }
}
