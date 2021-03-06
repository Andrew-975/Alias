package com.example.andrew_975.alias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.example.andrew_975.alias.entities.Description;
import com.example.andrew_975.alias.entities.Topic;
import com.example.andrew_975.alias.entities.Word;

import java.util.ArrayList;

import static com.example.andrew_975.alias.sqlite.TopicQ.insertSugarTopic;
import static com.example.andrew_975.alias.sqlite.WordQ.insertSugarWord;


public class AddDictActivity extends ActionBarActivity {

    String name = "";
    ArrayList<String> words = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dict);
        //Resources res = getResources();
        //final ArrayList<String> words = new ArrayList<String>();
        //Collections.addAll(words, res.getStringArray(R.array.words));
        final ListView list1 = (ListView) findViewById(R.id.editList);
        final EditText edit = (EditText) findViewById(R.id.dictName);
        final EditText edit1 = (EditText) findViewById(R.id.addWords);
        MyAdapter adapter1 = new MyAdapter(words, this, false);
        list1.setAdapter(adapter1);
        edit1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v ,int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN &&
                                event.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                        words.add(0, edit1.getText().toString());
                        name = edit.getText().toString();
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
        getMenuInflater().inflate(R.menu.menu_add_dict, menu);
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
        Intent intent = new Intent(AddDictActivity.this, DictionaryActivity.class);
        Topic t = new Topic(Exchange.lastTopicId,name);
        Log.v("mylog","" + "lastTopicId" + Exchange.lastTopicId);
        Exchange.lastTopicId++;
        insertSugarTopic(t);
        //Exchange.lastTopicId ++;
        for(int i = 0;i < words.size();i++){
            Word w = new Word(Exchange.lastWordId,new Description(0,"description"),null,t,words.get(i),false);
            Log.v("mylog","" + "word number:" + Exchange.lastWordId);
            Log.v("mylog","" + "word : " + words.get(i));
            insertSugarWord(w);
            Exchange.lastWordId++;
        }
        //Exchange.dictionary = new Topic(Exchange.lastId,name);
        startActivity(intent);
    }




}
