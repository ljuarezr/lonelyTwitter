package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;
import java.util.Date;

/**
 * Created by ljuarezr on 9/16/15.
 */
public class ImportantTweet extends Tweet {
    public ImportantTweet (String tweet, Date date) {
        super(tweet,date);
        this.setText(tweet);
        this.date = date;
    }

    public ImportantTweet(String tweet) throws IOException{
        super(tweet);
    }
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

    @Override
    public String getText(){
        return "!!!" + super.getText();
    }

}
