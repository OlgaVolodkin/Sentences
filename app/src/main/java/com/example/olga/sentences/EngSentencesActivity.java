package com.example.olga.sentences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EngSentencesActivity extends AppCompatActivity {

    String currentSent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eng_sentences);

        Intent intent = getIntent();

        if(intent.hasExtra("sentEng")) {
            currentSent = intent.getStringExtra("sentEng");
            buildArrayList();
        }
    }

    private void buildArrayList() {

        TextView sent = (TextView) findViewById(R.id.engTextView);
        sent.setText(currentSent);
    }

}
