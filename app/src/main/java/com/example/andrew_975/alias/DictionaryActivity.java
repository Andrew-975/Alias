package com.example.andrew_975.alias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.andrew_975.alias.entities.Description;
import com.example.andrew_975.alias.entities.Topic;
import com.example.andrew_975.alias.entities.Word;
import com.example.andrew_975.alias.sqlite.Database;

import static com.example.andrew_975.alias.sqlite.TopicQ.getAllSugarTopics;
import static com.example.andrew_975.alias.sqlite.TopicQ.getSugarTopic;
import static com.example.andrew_975.alias.sqlite.TopicQ.insertSugarTopic;
import static com.example.andrew_975.alias.sqlite.WordQ.getAllSugarWords;
import static com.example.andrew_975.alias.sqlite.WordQ.insertSugarWord;


public class DictionaryActivity extends ActionBarActivity {

    List<Topic> dicts = new ArrayList<Topic>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        fillDicts();
        /*if(Exchange.dictionary != null)
        {
            dicts.add(Exchange.dictionary);
            Exchange.dictionary = null;
        }*/
        MyAdapter adapter = new MyAdapter(dictsNames(), this, true);
        final ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
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

    public void onClickAdd(View view) {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
            }
        });
        Intent intent = new Intent(DictionaryActivity.this, AddDictActivity.class);
        startActivity(intent);
    }

    public ArrayList<String> dictsNames(){
        ArrayList<String> s = new ArrayList<String>();
        for(int i = 0; i < dicts.size();i++){
            s.add(dicts.get(i).getTopicText());
        }
        return s;
    }
    public void fillDicts(){


        List<Topic> allTopics = getAllSugarTopics();
        for(int i = 0;i < allTopics.size();i++){
            dicts.add(allTopics.get(i));
            Log.v("mylog", "" + allTopics.get(i).getId());
        }
    }

    public Topic getTopicfromList(String name){
        Topic t = new Topic(-1,"");
        for(int i = 0;i < dicts.size();i++){
            if(dicts.get(i).getTopicText().equals(name)){
                //return dicts.get(i);
                //break;
                t = dicts.get(i);
            }
        }
        return t;
    }
    public static List<Word> getWordsOfTopic(int topicId){
        Topic topic = getSugarTopic(topicId);
        List<Word> wordList = new ArrayList<>();
         List<Word> allWords = getAllSugarWords();
        for(int i = 0;i < allWords.size();i++) {
           if(allWords.get(i).getTopic().equals(topic)){
               wordList.add(allWords.get(i));
           }
        }
        return wordList;
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickEditAdapter(View view,String s){
        Intent intent = new Intent(this, EditActivity.class);
        intent.putExtra("name",s);
        startActivity(intent);
    }

    public void onClickImport(View view) {
        Intent intent = new Intent(DictionaryActivity.this, ImportActivity.class);
        startActivity(intent);
    }
    /*public void neu(){
        Database d = new Database(this);
        Topic t = new Topic(1, "это пиздец");
        insertSugarTopic(t);

        String[] s = {"konung","olaf","morzoviy","her"};
        for(int i = 0;i < 4;i++) {
            Word w = new Word(0,new Description(0,"description"),null,t,s[i],false);
            insertSugarWord(w);
        }
    }*/

}






