package com.example.olga.sentences;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        if(intent.hasExtra(getString(R.string.sentstr))) {
            int flg = intent.getIntExtra(getString(R.string.flagLang), 0);
            if (flg == HEB) {
                parentLayout.setBackgroundResource(R.drawable.imageheb);
            }
            if (flg == ENG) {
                parentLayout.setBackgroundResource(R.drawable.imageeng);
            }
            currentSent = intent.getStringExtra(getString(R.string.sentstr));
            sent.setText(currentSent);
        }
    }
}
