package com.example.andrew_975.alias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class TurnStat extends ActionBarActivity {

    private static final String ROUND = "Раунд";
    private static final String GAME = "Игра";
    private static final String DOT = " .";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_stat);

        TextView curTurnText = (TextView) findViewById(R.id.currentTurn);
        TextView curTeamState = (TextView) findViewById(R.id.currentTeam);

        curTurnText.setText(ROUND + Exchange.game.getRoundCount() + DOT + GAME + Exchange.game.getTurnCount());
        curTeamState.setText(Exchange.game.getCurrentTeamName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_turn_stat, menu);
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

    public void onClickStartRound(View view) {
        Intent intent = new Intent(TurnStat.this, GameProc.class);
        startActivity(intent);
    }
}