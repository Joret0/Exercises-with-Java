package twitter_test;

import org.junit.Assert;
import org.junit.Test;
import twitter.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TwitterTests {

    @Test
    @SuppressWarnings("unchecked")
    public void testStoreMessageOnTheServer() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        IServer server = new Server();
        Client client = new MicrowaveOven(server);
        List<String> list = new ArrayList<String>() {{
           add("Georgi");
           add("Ivan");
        }};
        Tweet tweet = new Message(list);
        client.receiveTweet(tweet);
        Field tweetField = server.getClass().getDeclaredField("tweet");
        tweetField.setAccessible(true);
        int listSize = list.size();

        Class<Message> messageClass = Message.class;
        Field messageField = messageClass.getDeclaredField("messages");
        messageField.setAccessible(true);
        List<String> opa = (List<String>) messageField.get(tweet);
        Assert.assertEquals(listSize, opa.size());
    }
}
