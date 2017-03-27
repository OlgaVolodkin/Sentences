package com.example.olga.sentences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayHeb = new ArrayList<>();
    ArrayList<String> arrayEng = new ArrayList<>();

    SharedPreferences prefs;

    int ENG = 999;
    int HEB = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void endBtnClk(View view) {
        if (arrayEng.size() == 0) {
            prefs = getSharedPreferences(getString(R.string.prefEng), MODE_PRIVATE);
            buildArrayList(ENG);
        }
       else {
            int i = new Random().nextInt(arrayEng.size());
            Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
            intent.putExtra(getString(R.string.sentstr), arrayEng.get(i));
            intent.putExtra(getString(R.string.flagLang), ENG);
            startActivity(intent);
       }
    }

    public void hebBtnClk(View view) {
        if (arrayHeb.size() == 0) {
            prefs = getSharedPreferences(getString(R.string.prefHeb), MODE_PRIVATE);
            buildArrayList(HEB);
        }
        else {
            int i = new Random().nextInt(arrayHeb.size());
            Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
            intent.putExtra(getString(R.string.sentstr), arrayHeb.get(i));
            intent.putExtra(getString(R.string.flagLang), HEB);
            startActivity(intent);
        }
    }

    private void buildArrayList(final int flg) {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                if (flg == 1) {
                    if (prefs.contains(getString(R.string.prefHeb)) == false) {
                        Sentences sentences = new Sentences();
                        arrayHeb = sentences.buildHeb();
                        SharedPreferences.Editor editor = prefs.edit();
                        Set<String> set = new HashSet<>();
                        set.addAll(arrayHeb);
                        editor.putStringSet(getString(R.string.prefHeb), set);
                        editor.commit();
                    }
                }
                if (flg == ENG) {
                    if (prefs.contains(getString(R.string.prefEng)) == false) {
                        Sentences sentences = new Sentences();
                        arrayEng = sentences.buildEng();
                        SharedPreferences.Editor editor = prefs.edit();
                        Set<String> set = new HashSet<>();
                        set.addAll(arrayEng);
                        editor.putStringSet(getString(R.string.prefEng), set);
                        editor.commit();
                    }
                }
                return arrayHeb;
            }

            @Override
            protected void onPostExecute(ArrayList<String> strings) {
                super.onPostExecute(strings);
                Set<String> set = null;
                if (flg == HEB) {
                   set = prefs.getStringSet(getString(R.string.prefHeb), null);
                }
                if (flg == ENG) {
                    set = prefs.getStringSet(getString(R.string.prefEng), null);
                }
                if (set != null) {
                    ArrayList<String> sample = new ArrayList<>(set);
                    int i = new Random().nextInt(sample.size());
                    Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
                    intent.putExtra(getString(R.string.sentstr), sample.get(i));
                    intent.putExtra(getString(R.string.flagLang), flg);
                    startActivity(intent);
                }
            }
        }.execute();
    }
}
