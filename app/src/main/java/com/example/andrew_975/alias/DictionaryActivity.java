package com.example.andrew_975.alias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class DictionaryActivity extends ActionBarActivity {

    ArrayList<DictionaryForAdd> dicts = new ArrayList<DictionaryForAdd>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        fillDicts();
        if(Exchange.dictionary != null)
        {
            dicts.add(Exchange.dictionary);
            Exchange.dictionary = null;
        }
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
            s.add(dicts.get(i).getName());
        }
        return s;
    }
    public void fillDicts(){
        for(int i = 0;i < 3;i++){
            ArrayList<String> s = new ArrayList<String>(Arrays.asList("kokoko","rrrrr","jhgfcjyhgc"));
            DictionaryForAdd d = new DictionaryForAdd("selech",s);
            dicts.add(d);
        }
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

}






