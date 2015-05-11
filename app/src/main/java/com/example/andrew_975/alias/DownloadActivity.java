package com.example.andrew_975.alias;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class DownloadActivity extends ActionBarActivity {

    List<String> di = new ArrayList(Arrays.asList( "The Game of Thrones", "Selechi", "Memesy"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        Resources res = getResources();
        ArrayList<String> di = new ArrayList<String>();
        Collections.addAll(di, res.getStringArray(R.array.add_dictionaries));
        ListView listDwn = (ListView) findViewById(R.id.downloadList);
        final ArrayAdapter<String> adapterDwn = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, di);
        listDwn.setAdapter(adapterDwn);
        listDwn.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                //TextView textView = (TextView) itemClicked;
                //String strText = textView.getText().toString(); // получаем текст нажатого элемента
                //выгружаем файл
                startActivity(new Intent(DownloadActivity.this, DictionaryActivity.class));

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_download, menu);
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
}
