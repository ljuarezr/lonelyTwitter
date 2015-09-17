package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by ljuarezr on 9/16/15.
 */
public class HappyMood extends CurrentMood {

    public HappyMood(Date date) {
        this.date = date;
    }

    public HappyMood() {
        this.date = default_date;
    }

    public Date getDate() {
        return this.date;
    }

    public String MoodRep() {
        return "I'm happy! :D ";
    }

}

