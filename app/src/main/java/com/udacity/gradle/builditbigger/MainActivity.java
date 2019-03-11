package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.android.jokeandroidlibrary.JokeActivity;


public class MainActivity extends AppCompatActivity {

    protected ProgressBar mJokeDisplayProgressBar = null;
    protected Button mJokeTellButton;
    protected Boolean isTestRun = false;
    protected String mTestJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mJokeTellButton = (Button) findViewById(R.id.bv_telljoke);
        mJokeDisplayProgressBar = (ProgressBar) findViewById(R.id.pb_joke_display);


        mJokeTellButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mJokeDisplayProgressBar.setVisibility(View.VISIBLE);
                executeAsyncTask();
            }
        });
        mJokeDisplayProgressBar.setVisibility(View.GONE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void executeAsyncTask() {
        new EndpointAsyncTask().execute( this);
    }


    public void startJokeActivity(String mJokeContentDisplayed) {
        if (!isTestRun) {
            mJokeDisplayProgressBar.setVisibility(View.GONE);
            Context context = getApplicationContext();
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra("JOKE_INTENT", mJokeContentDisplayed);
            context.startActivity(intent);

        }
    }
    /*public void tellJoke(View view) {
    //    new EndpointsAsyncTask().execute(this);

       *//* Joker joker = new Joker();
        startJokeActivity(joker);*//*
    }


   public void startJokeActivity(Joker joker){
       Intent intent = new Intent(this, JokeActivity.class);
       intent.putExtra("JOKE_INTENT", joker.tellJoke());
       startActivity(intent);

   }
*/
}
