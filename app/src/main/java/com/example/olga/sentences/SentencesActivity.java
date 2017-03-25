package com.example.olga.sentences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SentencesActivity extends AppCompatActivity {

    String currentSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentences);

        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.sentstr))) {
            currentSent = intent.getStringExtra(getString(R.string.sentstr));
            buildArrayList();
        }
    }

    private void buildArrayList() {
        TextView sent = (TextView) findViewById(R.id.hebTextView);
        sent.setText(currentSent);
    }
}
