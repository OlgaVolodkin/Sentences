package com.example.olga.sentences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
        //==if (arrayEng.size() == 0) {
            //==prefs = getSharedPreferences(getString(R.string.pref_eng), MODE_PRIVATE);
            //==buildArrayList(ENG);

            startDownload(ENG);
       //== }
       //==else {
           //== int i = new Random().nextInt(arrayEng.size());
            //==Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
            //==intent.putExtra(getString(R.string.sent_str), arrayEng.get(i));
            //==intent.putExtra(getString(R.string.flag_lang), ENG);
            //==startActivity(intent);
       //==}
    }

    public void hebBtnClk(View view) {
        //==if (arrayHeb.size() == 0) {
        //==   prefs = getSharedPreferences(getString(R.string.pref_heb), MODE_PRIVATE);
        //==   buildArrayList(HEB);

            startDownload(HEB);
        //==}
        //==else {
        //==    int i = new Random().nextInt(arrayHeb.size());
        //==    Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
        //==    intent.putExtra(getString(R.string.sent_str), arrayHeb.get(i));
        //==   intent.putExtra(getString(R.string.flag_lang), HEB);
        //==   startActivity(intent);
        //== }
    }

    private void buildArrayList(final int flg) {
        new AsyncTask<Void, Void, ArrayList<String>>() {
            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                if (flg == 1) {
                    if (prefs.contains(getString(R.string.pref_heb)) == false) {
                        Sentences sentences = new Sentences();
                        arrayHeb = sentences.buildHeb();
                        SharedPreferences.Editor editor = prefs.edit();
                        Set<String> set = new HashSet<>();
                        set.addAll(arrayHeb);
                        editor.putStringSet(getString(R.string.pref_heb), set);
                        editor.commit();
                    }
                }
                if (flg == ENG) {
                    if (prefs.contains(getString(R.string.pref_eng)) == false) {
                        Sentences sentences = new Sentences();
                        arrayEng = sentences.buildEng();
                        SharedPreferences.Editor editor = prefs.edit();
                        Set<String> set = new HashSet<>();
                        set.addAll(arrayEng);
                        editor.putStringSet(getString(R.string.pref_eng), set);
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
                   set = prefs.getStringSet(getString(R.string.pref_heb), null);
                }
                if (flg == ENG) {
                    set = prefs.getStringSet(getString(R.string.pref_eng), null);
                }
                if (set != null) {
                    ArrayList<String> sample = new ArrayList<>(set);
                    int i = new Random().nextInt(sample.size());
                    Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
                    intent.putExtra(getString(R.string.sent_str), sample.get(i));
                    intent.putExtra(getString(R.string.flag_lang), flg);
                    startActivity(intent);
                }
            }
        }.execute();
    }


    private void startDownload(final int flg) {
        new AsyncTask<Void, Void, ArrayList<String>>(){

            @Override
            protected ArrayList<String> doInBackground(Void... voids) {
                ArrayList<String> sentList = null;
                HttpURLConnection connection = null;
                URL url = null;
                try {
                    if (flg == ENG) {
                        url = new URL("https://sentences-cbddf.firebaseio.com/eng.json");
                    }
                    else if (flg == HEB) {
                        url = new URL("https://sentences-cbddf.firebaseio.com/heb.json");
                    }
                    if (url == null) {
                        return null;
                    }
                    connection = (HttpURLConnection) url.openConnection();

                    InputStream inputStream = connection.getInputStream();  //??????????
                    Reader reader = new InputStreamReader(inputStream, "UTF-8");

                    Gson gson = new Gson();

                    sentList = gson.fromJson(reader, new TypeToken<ArrayList<String>>(){}.getType());

                    return sentList;
                }

                catch (MalformedURLException e) {e.printStackTrace();}
                catch (IOException e) {e.printStackTrace();}
                catch (Exception e) {e.printStackTrace();}
                finally {connection.disconnect();}

                return sentList;
            }

            @Override
            protected void onPostExecute(ArrayList<String> sents) {
                super.onPostExecute(sents);

                if (sents != null && sents.size() != 0) {
                    int i = new Random().nextInt(sents.size());
                    Intent intent = new Intent(MainActivity.this, SentencesActivity.class);
                    intent.putExtra(getString(R.string.sent_str), sents.get(i));
                    intent.putExtra(getString(R.string.flag_lang), flg);
                    startActivity(intent);
                }
                else {  //if list is empty (no sents or not internet) - alert dialog (pop up window)
                    getSupportFragmentManager().beginTransaction().add(new NoInternetDialogFragment(), getString(R.string.internet)).commitAllowingStateLoss();
                }
            }
        }.execute();
    }
}
