package com.example.olga.sentences;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HebSentencesActivity extends AppCompatActivity {

    //ArrayList<String> sentHebArray = new ArrayList<>();

    String currentSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heb_sentences);

        Intent intent = getIntent();

        if(intent.hasExtra("sentHeb")) {

            currentSent = intent.getStringExtra("sentHeb");

            buildArrayList();
        }
    }

    private void buildArrayList() {

        TextView sent = (TextView) findViewById(R.id.hebTextView);
        sent.setText(currentSent);

        /*

        new AsyncTask<Void, Void, ArrayList<String>>() {

            SharedPreferences prefs = getSharedPreferences("MySentence", MODE_PRIVATE);

            @Override
            protected ArrayList<String> doInBackground(Void... voids) {

                SharedPreferences.Editor editor = prefs.edit();
                Set<String> set = new HashSet<String>();
                set.addAll(sentHebArray);
                editor.putStringSet("MySentence", set);
                editor.commit();

                return sentHebArray;
            }

            @Override
            protected void onPostExecute(ArrayList<String> strings) {
                super.onPostExecute(strings);

                Set<String> set = prefs.getStringSet("MySentence", null);
                ArrayList<String> sample = new ArrayList<>(set);

                Collections.shuffle(sample);

                TextView sent = (TextView) findViewById(R.id.textView);
                sent.setText(sample.get(0));

            }
        }.execute();
    */
    }
}
