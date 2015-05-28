package com.example.andrew_975.alias;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;

import com.example.andrew_975.alias.entities.Team;

import java.util.ArrayList;
import java.util.Collections;


public class TeamS extends ActionBarActivity {

    final ArrayList<String> teams = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_s);
        Resources res = getResources();
        Collections.addAll(teams, res.getStringArray(R.array.teamset));
        MyAdapter adapter = new MyAdapter(teams, this, false);
        final ListView list = (ListView) findViewById(R.id.listView2);
        list.setAdapter(adapter);
        final EditText edit1 = (EditText) findViewById(R.id.editText4);
        edit1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v ,int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                        event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    teams.add(0, edit1.getText().toString());
                    edit1.setText("");
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_team, menu);
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

    public Exchange onClickTeamSReady(ArrayList<Team> array){
        Exchange exchange = new Exchange(array);
        return exchange;
    }

    public ArrayList<Team> convertToTeams(ArrayList<String> t)
    {
        ArrayList<Team> teams = new ArrayList<Team>();
        for(int i = 0 ; i < t.size(); i++)
        {
            teams.get(i).setTeamName(t.get(i));
            teams.get(i).setTeamId(i);
        }
        return teams;
    }
    public void onClickBackToGame (View view) {
        Intent intent = new Intent(TeamS.this, GameActivity.class);
        //intent.putExtra("arrayTeams",array);
        onClickTeamSReady(convertToTeams(teams));
        //Log.
        startActivity(intent);
    }
}
