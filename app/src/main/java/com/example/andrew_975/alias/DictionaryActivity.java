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
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class DictionaryActivity extends ActionBarActivity {

    //String[] dict = getResources().getStringArray(R.array.dictionaries);
    //ArrayList<String> dicts = new ArrayList(Arrays.asList( "The Game of Thrones", "Selechi", "Memesy"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        Resources res = getResources();
        ArrayList<String> dicts = new ArrayList<String>();
        Collections.addAll(dicts, res.getStringArray(R.array.dictionaries));

        MyAdapter adapter = new MyAdapter(dicts, this);
        ListView list = (ListView) findViewById(R.id.listView);
        //final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dicts);
        list.setAdapter(adapter);
        /*list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента
                    startActivity(new Intent(DictionaryActivity.this, EditActivity.class));
            }
        });*/
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

    public void onClickBack(View view) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickEdit(View view) {
        Intent intent = new Intent(DictionaryActivity.this, EditActivity.class);
        startActivity(intent);
    }

    public void onClickImport(View view) {
        Intent intent = new Intent(DictionaryActivity.this, ImportActivity.class);
        startActivity(intent);
    }

}






