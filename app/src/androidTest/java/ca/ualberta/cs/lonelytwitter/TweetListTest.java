package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Created by ljuarezr on 9/30/15.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2 {
    public TweetListTest() {
        super(LonelyTwitterActivity.class);
    }


    public void testRemoveTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addTweet(tweet);
        tweetList.removeTweet(tweet);
        assertFalse(tweetList.hasTweet(tweet));
    }

    public void testHasTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        assertFalse(tweetList.hasTweet(tweet));
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
    }

    public void testAddTweet() {
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addTweet(tweet);
        assertTrue(tweetList.hasTweet(tweet));
        Tweet doubletweet = new NormalTweet("hihihihi");
        tweetList.addTweet(doubletweet);
        assertTrue(tweetList.hasTweet(doubletweet));
    }

    public void testGetTweet(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addTweet(tweet);
        Tweet returnedTweet = tweetList.getTweet(0);
        assertTrue((tweet.date.equals(returnedTweet.date)) &&
                (tweet.getText().equals(returnedTweet.getText())));

    }

    public void testGetTweets(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addTweet(tweet);
        Tweet tweet2 = new NormalTweet("hehehehe");
        tweetList.addTweet(tweet2);
        Tweet tweet3 = new NormalTweet("hahahaha");
        tweetList.addTweet(tweet3);

    }

    public void testGetCount(){
        TweetList tweetList = new TweetList();
        Tweet tweet = new NormalTweet("hihihihi");
        tweetList.addTweet(tweet);
        int count = tweetList.getCount();
        assertEquals(1, count);
    }
}