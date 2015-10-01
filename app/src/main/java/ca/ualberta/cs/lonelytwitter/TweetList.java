package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

/**
 * Created by ljuarezr on 9/30/15.
 */
public class TweetList {
    private ArrayList<Tweet> tweets = new ArrayList<Tweet>();

    public void removeTweet(Tweet tweet){
        tweets.remove(tweet);
    }

    public void  addTweet(Tweet tweet) {
        if (tweets.contains(tweet)){
            throw new IllegalArgumentException("Tweet already exists!");
        }
        tweets.add(tweet);
    }

    public boolean hasTweet(Tweet tweet) {
        return tweets.contains(tweet);
    }

    public Tweet  getTweet(int index){
        return tweets.get(index);
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }

    public int getCount(){
        return tweets.size();
    }

}
