package com.example.andrew_975.alias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrew_975.alias.entities.Description;
import com.example.andrew_975.alias.entities.Topic;
import com.example.andrew_975.alias.entities.Word;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrew_975.alias.sqlite.TopicQ.getSugarTopic;
import static com.example.andrew_975.alias.sqlite.WordQ.deleteSugarWord;
import static com.example.andrew_975.alias.sqlite.WordQ.getAllSugarWords;
import static com.example.andrew_975.alias.sqlite.WordQ.insertSugarWord;
import static com.example.andrew_975.alias.sqlite.WordQ.updateSugarWord;


public class EditActivity extends ActionBarActivity {

    List<Word> words = DictionaryActivity.getWordsOfTopic(Exchange.CurrentTopicId);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        String name = getIntent().getStringExtra("name");
        setName(name);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit, menu);
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
    public void onClickBackToDict(View view) {
        Intent intent = new Intent(EditActivity.this, DictionaryActivity.class);
        startActivity(intent);
    }
    public void onClickOk(View view) {
        EditText edit = (EditText) findViewById(R.id.editTextAdd);
        //Word w = new Word(Exchange.lastWordId+1,edit.getText().toString(),getSugarTopic(Exchange.CurrentTopicId));
        Word w =  new Word(Exchange.lastWordId, new Description(0, "description"), null, getSugarTopic(Exchange.CurrentTopicId), edit.getText().toString(),false);
        insertSugarWord(w);
        Log.v("mylog", "-------");
        Log.v("mylog", "word number:" + Exchange.lastWordId);
        Log.v("mylog", "topic : " + getSugarTopic(Exchange.CurrentTopicId));
        Log.v("mylog", "word : " + edit.getText().toString());
        edit.setText("");
    }

    public void onClickDel(View view) {
        EditText edit = (EditText) findViewById(R.id.addWords);
        for(int i = 0; i < words.size();i++){
            String s = edit.getText().toString();
            if(words.get(i).getWordText().equals(s)){
                deleteSugarWord(words.get(i).getId());
                Log.v("mylog", " word deleted: " + words.get(i).getId());
            }
        }
        edit.setText("");
    }
    public void setName(String name)
    {
        TextView t = (TextView) findViewById(R.id.editName);
        t.setText(name);
    }
}
