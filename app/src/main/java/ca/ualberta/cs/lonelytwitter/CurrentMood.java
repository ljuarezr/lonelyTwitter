package ca.ualberta.cs.lonelytwitter;

import java.util.Date;
/**
 * Created by ljuarezr on 9/16/15.
 */
public abstract class CurrentMood {
    protected static final Date default_date  = new Date();
    protected Date date;

    public CurrentMood(Date date) {
        this.date = date;
    }

    public CurrentMood() {
        this.date = default_date;
    }

    public Date getDate() {
        return this.date;
    }
}
