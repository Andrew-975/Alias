package com.example.andrew_975.alias;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.AlertDialog;

import com.example.andrew_975.alias.entities.Game;
import com.example.andrew_975.alias.entities.Parameters;
import com.example.andrew_975.alias.entities.Topic;


public class GameActivity extends ActionBarActivity {

    public Game game;
    public Parameters params;
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
        t = (TextView) findViewById(R.id.timeForRoundValueText);
        t1 = new TextView(this);
        t1 = (TextView) findViewById(R.id.wordsToWinValueText);

        Spinner spinner = (Spinner) findViewById(R.id.chooseDictionarySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.teamNames, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
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

        // SeekBars.
        final SeekBar timeForRoundSeekBar = (SeekBar) findViewById(R.id.timeForRoundBar);
        timeForRoundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
        timeForRoundSeekBar.setProgress(Parameters.STANDARD_TURN_LENGTH_SECONDS);
        final SeekBar wordsToStopSeekBar = (SeekBar) findViewById(R.id.seekBar2);
        wordsToStopSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

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
        wordsToStopSeekBar.setProgress(Parameters.STANDARD_NUMBER_WORDS_TO_WIN);
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
    //public void

    public void startGame() {
        params = new Parameters(turnLengthSeconds, numberWordsToWin, topic);
        Exchange.game = new Game(Exchange.teams, params);
        Exchange.game.start();
        //Exchange.game = game;
    }
}
