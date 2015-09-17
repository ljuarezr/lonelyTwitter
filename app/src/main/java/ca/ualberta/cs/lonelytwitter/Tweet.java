package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by ljuarezr on 9/16/15.
 */
public abstract class Tweet extends Object implements Tweetable {
    private String text;
    protected Date date;

    ArrayList<CurrentMood> moodList = new ArrayList<CurrentMood>();


    public Tweet(String tweet, Date date) {
        this.setText(tweet);
        this.date = date;
    }
    public Tweet(String tweet) throws IOException{
        this.setText(tweet);
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;

    }

    public void setText(String text) {
            if (text.length() <= 140)
            this.text = text;
        }

    public abstract Boolean isImportant();
}
