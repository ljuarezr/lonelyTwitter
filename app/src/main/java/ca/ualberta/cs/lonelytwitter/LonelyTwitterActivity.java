package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav"; //model
	private EditText bodyText;  //model
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>(); //model
	private ListView oldTweetsList; //model
	private ArrayAdapter<Tweet> adapter;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main); //controller

		bodyText = (EditText) findViewById(R.id.body); //controller
		Button saveButton = (Button) findViewById(R.id.save); //controller
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList); //view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) { //controller
				setResult(RESULT_OK); //model
				String text = bodyText.getText().toString(); //model data
				tweets.add(new NormalTweet(text)); //controller
				saveInFile(); //model
				//dataObject.saveInFile() //controller
				adapter.notifyDataSetChanged(); //view

			}
		});
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart(); //controller
		loadFromFile(); //model
		adapter = new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweets); //model
		oldTweetsList.setAdapter(adapter); //controller
		adapter.notifyDataSetChanged(); //view
	}

	private void loadFromFile() {
		try {
			FileInputStream fis = openFileInput(FILENAME); //model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis)); //model
			Gson gson = new Gson(); //model
			// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/Gson.html, 2015-09-23
			Type arraylistType = new TypeToken<ArrayList<NormalTweet>>() {}.getType(); //model
			tweets = gson.fromJson(in, arraylistType); //model/controller

		} catch (FileNotFoundException e) {
			tweets = new ArrayList<Tweet>(); //model
		} catch (IOException e) { //model
			throw new RuntimeException(e); //model
		}
	}
	
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0); //model
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos)); //model
			Gson gson = new Gson(); //model
			gson.toJson(tweets, out); //controller
			out.flush(); //controller
			fos.close(); //controller
		} catch (FileNotFoundException e) { //model
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //model
		} catch (IOException e) { //model
			// TODO Auto-generated catch block
			throw new RuntimeException(e); //model
		}
	}
}