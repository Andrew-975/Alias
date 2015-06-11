package com.example.andrew_975.alias;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrew_975.alias.entities.Game;
import com.example.andrew_975.alias.entities.Parametres;
import com.example.andrew_975.alias.entities.Team;
import com.example.andrew_975.alias.entities.Topic;

import java.util.ArrayList;

import com.example.andrew_975.alias.entities.Parametres;
import com.example.andrew_975.alias.entities.Team;

import java.util.ArrayList;


public class GameActivity extends ActionBarActivity {

    public Game game;
    public Parametres params;
    protected int turnLengthSeconds;
    protected int numberWordsToWin;
    protected Topic topic;
    public TextView t;
    public TextView t1;
    //ArrayList<Team> teams;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        t = new TextView(this);
        t = (TextView)findViewById(R.id.textView12);
        t1 = new TextView(this);
        t1 = (TextView)findViewById(R.id.textView14);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teams, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        final SeekBar sk=(SeekBar) findViewById(R.id.seekBar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                turnLengthSeconds = progress;

                mHandler1.postDelayed(mUpdateUITimerTask1, 0);
            }
        });

        final SeekBar sk1=(SeekBar) findViewById(R.id.seekBar2);
        sk1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                numberWordsToWin = progress;
                mHandler.postDelayed(mUpdateUITimerTask, 0);
            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String nameTopic = parentView.getItemAtPosition(position).toString();
                topic = new Topic(1, nameTopic);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            // do whatever you want to change here, like:
            t1.setText("" + numberWordsToWin);
        }
    };

    private final Handler mHandler = new Handler();

    private final Runnable mUpdateUITimerTask1 = new Runnable() {
        public void run() {
            // do whatever you want to change here, like:
            t.setText("" + turnLengthSeconds);
        }
    };

    private final Handler mHandler1 = new Handler();

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
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
    public void onClickGameToMain(View view) {
        Intent intent = new Intent(GameActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void onClickGameStart(View view) {
        startGame();
        Intent intent = new Intent(GameActivity.this, TurnStat.class);
        startActivity(intent);
    }
    public void onClickEditTeams(View view) {
        Intent intent = new Intent(GameActivity.this, TeamS.class);
        startActivity(intent);
    }

    public void startGame() {
        params = new Parametres(turnLengthSeconds, numberWordsToWin, topic);
        Exchange.game = new Game(Exchange.teams, params);
        Exchange.game.start();
        //Exchange.game = game;
    }
}
