package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ljuarezr on 9/16/15.
 */
public class NormalTweet extends Tweet {
    public NormalTweet (String tweet, Date date) {
            super(tweet,date);
            this.setText(tweet);
            this.date = date;
    }

    public NormalTweet(String tweet) throws IOException{
            super(tweet);
    }

    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
