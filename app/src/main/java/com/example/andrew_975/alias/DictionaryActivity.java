package com.example.andrew_975.alias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

public class DictionaryActivity extends ActionBarActivity {

    ArrayList<String> dicts = new ArrayList(Arrays.asList("Наука", "The Lord Of Rings", "Наша группа", "Что происходит", "Kolbaster"));
            //Arrays.asList(getResources().getStringArray(R.array.dictionaries));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dictionary, menu);
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

    public void onClickAdd(View view) {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента

                //if(strText.equalsIgnoreCase(getResources().getString(R.string.name1))) {
                // Запускаем активность, связанную с определенным именем кота
                //Intent intent = new Intent(DictionaryActivity.this, EditActivity.class);
                //startActivity(intent);
                //}
            }
        });
        Intent intent = new Intent(DictionaryActivity.this, AddDictActivity.class);
        startActivity(intent);
    }

    public void onClickBack(View view) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onClickDownload(View view) {
        Intent intent = new Intent(DictionaryActivity.this, DownloadActivity.class);
        startActivity(intent);
    }
    public void onClickEdit(View view) {
        Intent intent = new Intent(DictionaryActivity.this, EditActivity.class);
        startActivity(intent);
    }

}






