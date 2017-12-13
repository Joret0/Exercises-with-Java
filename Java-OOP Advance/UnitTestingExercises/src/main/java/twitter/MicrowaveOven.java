package twitter;

public class MicrowaveOven implements Client{
    private IServer server;

    public MicrowaveOven(IServer server) {
        this.server = server;
    }

    @Override
    public void receiveTweet(Tweet tweet) {
        OutputWriter.writeLine(tweet.retrieveMessage());
        this.server.storeTweet(tweet);
    }
}
