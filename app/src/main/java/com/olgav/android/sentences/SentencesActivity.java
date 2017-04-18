package com.olgav.android.sentences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.olgav.android.sentences.R;

public class SentencesActivity extends AppCompatActivity {

    String currentSent;

    int ENG = 999;
    int HEB = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentences);

        TextView sent = (TextView) findViewById(R.id.hebTextView);
        LinearLayout parentLayout = (LinearLayout) findViewById(R.id.parentLayout);

        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.sent_str))) {
            int flg = intent.getIntExtra(getString(R.string.flag_lang), 0);
            if (flg == HEB) {
                parentLayout.setBackgroundResource(R.drawable.imageheb);
            }
            if (flg == ENG) {
                parentLayout.setBackgroundResource(R.drawable.imageeng);
            }
            currentSent = intent.getStringExtra(getString(R.string.sent_str));
            sent.setText(currentSent);
        }
    }
}
