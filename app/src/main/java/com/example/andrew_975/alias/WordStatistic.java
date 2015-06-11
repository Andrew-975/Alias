package com.example.andrew_975.alias;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.andrew_975.alias.entities.GameWord;

import java.util.ArrayList;


public class WordStatistic extends ActionBarActivity {
    public String nameTeam;
    public ArrayList<GameWord> gameWords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_statistic);
        Resources res = getResources();
        //nameTeam = Exchange
        gameWords.addAll(Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords());

        InteractiveArrayAdapter adapter = new InteractiveArrayAdapter(gameWords, this, false);
        final ListView list = (ListView) findViewById(R.id.listView3);
        list.setAdapter(adapter);
        /*InteractiveArrayAdapter adapter = new InteractiveArrayAdapter(this,
                getModel());
        list.setListAdapter(adapter);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_statistic, menu);
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

    public void onClickNextTurn (View view) {
        Intent intent = new Intent(WordStatistic.this, RoundStat.class);
        startActivity(intent);
    }
}
