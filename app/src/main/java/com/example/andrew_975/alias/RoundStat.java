package com.example.andrew_975.alias;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class RoundStat extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_stat);

        ListView listView1 = (ListView)findViewById(R.id.teamListLastRound);

        final String[] teams = new String[] {"Team1", "Team2", "Team3"};

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, teams);

        listView1.setAdapter(adapter1);

        ListView listView1c = (ListView)findViewById(R.id.countListLastRound);

        final String[] count1 = new String[] {"Team1", "Team2", "Team3"};

        ArrayAdapter<String> adapter1c = new ArrayAdapter<String>(this,	android.R.layout.simple_list_item_1, count1);

        listView1.setAdapter(adapter1c);


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
}
