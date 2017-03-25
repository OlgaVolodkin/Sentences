package com.example.olga.sentences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayHeb = new ArrayList<>();
    ArrayList<String> arrayEng = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void endBtnClk(View view) {
        if (arrayEng.size() == 0) {
           buildArrayListEng();
        }
       else {
            Collections.shuffle(arrayEng);
            Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
            intent.putExtra(getString(R.string.sentstr), arrayEng.get(0));
            startActivity(intent);
       }
    }

    public void hebBtnClk(View view) {
        if (arrayHeb.size() == 0) {
            buildArrayListHeb();
        }
        else {
            Collections.shuffle(arrayHeb);
            Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
            intent.putExtra(getString(R.string.sentstr), arrayHeb.get(0));
            startActivity(intent);
        }
    }

    private void buildArrayListHeb() {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            SharedPreferences prefs = getSharedPreferences(getString(R.string.prefHeb), MODE_PRIVATE);
            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                //if (prefs.contains("MySentenceHeb") == false) {
                    Sentences sentences = new Sentences();
                    arrayHeb = sentences.buildHeb();
                    SharedPreferences.Editor editor = prefs.edit();
                    Set<String> set = new HashSet<>();
                    set.addAll(arrayHeb);
                    editor.putStringSet(getString(R.string.prefHeb), set);
                    editor.commit();
                //}
                return arrayHeb;
            }

            @Override
            protected void onPostExecute(ArrayList<String> strings) {
                super.onPostExecute(strings);
                Set<String> set = prefs.getStringSet(getString(R.string.prefHeb), null);
                ArrayList<String> sample = new ArrayList<>(set);
                Collections.shuffle(sample);
                Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
                //intent.putStringArrayListExtra("sent", arrayHeb);
                intent.putExtra(getString(R.string.sentstr),sample.get(0));
                startActivity(intent);
            }
        }.execute();
    }

    private void buildArrayListEng() {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            SharedPreferences prefs = getSharedPreferences(getString(R.string.prefEng), MODE_PRIVATE);
            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                //if (prefs.contains("MySentenceEng") == false) {
                    Sentences sentences = new Sentences();
                    arrayEng = sentences.buildEng();
                    SharedPreferences.Editor editor = prefs.edit();
                    Set<String> set = new HashSet<>();
                    set.addAll(arrayEng);
                    editor.putStringSet(getString(R.string.prefEng), set);
                    editor.commit();
             //   }
                return arrayEng;
            }

            @Override
            protected void onPostExecute(ArrayList<String> strings) {
                super.onPostExecute(strings);
                Set<String> set = prefs.getStringSet(getString(R.string.prefEng), null);
                ArrayList<String> sample = new ArrayList<>(set);
                Collections.shuffle(sample);
                Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
                intent.putExtra(getString(R.string.sentstr),sample.get(0));
                startActivity(intent);
            }
        }.execute();
    }
}
