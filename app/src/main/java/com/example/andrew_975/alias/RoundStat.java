package com.example.andrew_975.alias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class RoundStat extends ActionBarActivity {

    private static final String ROUND = "Раунд";
    private static final String WORDS_COUNT_1 = "Для победы нужно ";
    private static final String WORDS_COUNT_2 = "слов.";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_stat);

        TextView curRoundText = (TextView) findViewById(R.id.currentRound);
        TextView wordsCountText = (TextView) findViewById(R.id.wordsCount);

        curRoundText.setText(ROUND + " " + Exchange.game.getRoundCount());
        wordsCountText.setText(WORDS_COUNT_1 + Exchange.game.getNumberWordsToWin() + WORDS_COUNT_2);
        
        ListView listView1 = (ListView)findViewById(R.id.teamListLastRound);
        ListView listView2 = (ListView)findViewById(R.id.teamListAll);

        ArrayList<String> arrayList = Exchange.game.getAllTeamNames();
        final String [] teams = new String[arrayList.size()];
        arrayList.toArray(teams);
        
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, teams);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, teams);

        listView1.setAdapter(adapter1);
        listView2.setAdapter(adapter2);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_round_stat, menu);
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

    public void onClickEndRoundStatistic(View view) {
        Intent intent = new Intent(RoundStat.this, TurnStat.class);
        startActivity(intent);
    }
}
