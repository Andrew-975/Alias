package com.example.andrew_975.alias;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.andrew_975.alias.entities.Description;
import com.example.andrew_975.alias.entities.Topic;
import com.example.andrew_975.alias.entities.Word;
import com.example.andrew_975.alias.sqlite.DBQueries;
import com.example.andrew_975.alias.sqlite.Database;

import java.io.IOException;

import static com.example.andrew_975.alias.sqlite.TopicQ.deleteSugarTopic;
import static com.example.andrew_975.alias.sqlite.TopicQ.insertSugarTopic;
import static com.example.andrew_975.alias.sqlite.WordQ.insertSugarWord;

public class MainActivity extends ActionBarActivity {

    //Context context;
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /* Database myDbHelper = new Database(this);
       //myDbHelper = new Database(this);

       try {

           myDbHelper.createDataBase();

       } catch (IOException ioe) {

           throw new Error("Unable to create database");

       }

       try {
           myDbHelper.openDataBase();

       } catch (java.sql.SQLException e) {
           e.printStackTrace();
       }
       DBQueries.createAllTables(myDbHelper.getWritableDatabase());*/
   }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClickDict(View view) {
            Intent intent = new Intent(MainActivity.this, DictionaryActivity.class);
            startActivity(intent);
        }
    public void onClickSettings(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
    public void onClickAbout(View view) {
        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(intent);
    }
    public void onClickGame(View view) {
        Intent intent = new Intent(MainActivity.this, TeamS.class);
        startActivity(intent);
    }
    public void onClickHowToPlay(View view) {
        Intent intent = new Intent(MainActivity.this, HowToPlayActivity.class);
        startActivity(intent);
    }


}

