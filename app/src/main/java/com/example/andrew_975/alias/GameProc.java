package com.example.andrew_975.alias;

import java.util.Timer;
import java.util.TimerTask;
import android.content.res.Resources;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class GameProc extends ActionBarActivity {

    int a;
    private Timer mTimer;
    private MyTimerTask mMyTimerTask;
    private TextView tV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_proc);

        tV = (TextView) findViewById(R.id.textView12);
        if (mTimer != null) {
            mTimer.cancel();
        }
        mTimer = new Timer();
        mMyTimerTask = new MyTimerTask();

        a = 30;
        mTimer.schedule(mMyTimerTask, 1000, 1000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game_proc, menu);
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
    public void onClickEndRound(View view) {
        Intent intent = new Intent(GameProc.this, EndRound.class);
        startActivity(intent);
    }
    public void onClickProcToMain (View view){
        Intent intent = new Intent(GameProc.this, MainActivity.class);
        startActivity(intent);
    }
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tV.setText("" + a + " sec");
                    if (a == 0) {
                        mTimer.cancel();
                        mTimer = null;
                    }
                    a--;
                }
            });
        }
    }
}

