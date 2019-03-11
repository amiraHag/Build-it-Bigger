package com.example.android.jokeandroidlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        jokeTextView = (TextView) findViewById(R.id.tv_joke_content);

        if(intent.getStringExtra("JOKE_INTENT") != null){
            jokeTextView.setText(intent.getStringExtra("JOKE_INTENT"));

        }
        else{
            jokeTextView.setText("sorry we couldn't find any joke");
        }
    }
}
