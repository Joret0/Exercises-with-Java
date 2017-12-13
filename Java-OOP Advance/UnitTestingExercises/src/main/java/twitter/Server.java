package twitter;

import java.util.ArrayList;
import java.util.List;

public class Server implements IServer{

    private List<Tweet> tweets;

    public Server() {
        this.tweets = new ArrayList<>();
    }

    @Override
    public void storeTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }
}
