package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by ljuarezr on 9/30/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void delete(Tweet tweet){
        tweets.remove(tweet);
    }

    public void  add(Tweet tweet) {
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet  getTweet(int index){
        return tweets.get(index);
    }

}
