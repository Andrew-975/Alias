package com.example.andrew_975.alias;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andrew_975.alias.entities.GameWord;

import java.util.ArrayList;


public class WordStatistic extends ActionBarActivity {
    public String nameTeam;
    public TextView t3;
    public Button bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_statistic);
        Resources res = getResources();
        t3 = new TextView(this);
        t3 = (TextView)findViewById(R.id.textView28);
        bt8 = (Button) findViewById(R.id.button8);
        nameTeam = Exchange.game.getCurrentTeamName();
        mHandler.postDelayed(mUpdateUITimerTask, 0);

        InteractiveArrayAdapter adapter = new InteractiveArrayAdapter(this, false);
        final ListView list = (ListView) findViewById(R.id.listView3);
        list.setAdapter(adapter);
        bt8.setText("Количество верных: " + Exchange.game.getCurrentTurn().countStatistics());
        Exchange.wordStatistic = this;
    }

    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            // do whatever you want to change here, like:
            t3.setText(nameTeam);
        }
    };

    private final Handler mHandler = new Handler();

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

    public void changeVal(int num) {
        bt8.setText("Количество верных: " + Exchange.game.getCurrentTurn().countStatistics());
    }
}
