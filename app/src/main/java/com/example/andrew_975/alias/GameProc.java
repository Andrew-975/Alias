package com.example.andrew_975.alias;

import java.util.Timer;
import java.util.TimerTask;
import android.content.res.Resources;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.andrew_975.alias.entities.Turn;


public class GameProc extends ActionBarActivity {
    ProgressBar myProgressBar;
    int myProgress = 0;
    TextView gameWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_proc);

        myProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        gameWord = (TextView) findViewById(R.id.gameWordCurrent);
        new Thread(myThread).start();
        //public Turn turn = new Turn(playingTeam, parametres);

        TextView teamName = (TextView) findViewById(R.id.gameProcTeamName);
        //gameWord = (TextView) findViewById(R.id.gameWordCurrent);

        teamName.setText(Exchange.game.getCurrentTeamName());
        gameWord.setText(Exchange.game.getCurrentTurn().suggestNewWord().getInLowercase());
    }

    private Runnable myThread = new Runnable() {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            while (myProgress < 100) {
                try {
                    myHandle.sendMessage(myHandle.obtainMessage());
                    Thread.sleep(Exchange.game.getTurnLengthSeconds() * 10);
                } catch (Throwable t) {
                }
            }
            Intent intent = new Intent(GameProc.this, WordStatistic.class);
            startActivity(intent);
        }

        Handler myHandle = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                myProgress++;
                myProgressBar.setProgress(myProgress);
            }
        };
    };

    private final Runnable mUpdateUITimerTask = new Runnable() {
        public void run() {
            // do whatever you want to change here, like:
            Exchange.game.getCurrentTurn().getCurrentWord().markGuessed();
            gameWord.setText(Exchange.game.getCurrentTurn().suggestNewWord().getInLowercase());
        }
    };
    private final Runnable mUpdateUITimerTask1 = new Runnable() {
        public void run() {
            // do whatever you want to change here, like:
            Exchange.game.getCurrentTurn().getCurrentWord().markUnguessed();
            gameWord.setText(Exchange.game.getCurrentTurn().suggestNewWord().getInLowercase());
        }
    };

    private final Handler mHandler11 = new Handler();

    private final Handler mHandler1 = new Handler();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_proc, menu);
        return true;
    }

    public void onClickApprove(View view) {
        mHandler1.postDelayed(mUpdateUITimerTask, 0);
    }

    public void onClickDecline(View view) {
        mHandler11.postDelayed(mUpdateUITimerTask1, 0);
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

