package com.example.andrew_975.alias;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.EditText;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.view.View.OnKeyListener;
import android.util.Log;
import android.widget.Toast;
import android.widget.TextView;





public class DictionaryActivity extends ActionBarActivity {

    ArrayList<String> dicts = new ArrayList(Arrays.asList("Science", "Art", "My Dictionary 1", "My Dictionary 2", "My Dictionary 3"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);
        ListView list = (ListView) findViewById(R.id.listView);
        final EditText edit = (EditText) findViewById(R.id.editText);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dicts);
        list.setAdapter(adapter);
        edit.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                Log.d("myLogs", "here");
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_0) {
                        dicts.add(0, edit.getText().toString());
                        adapter.notifyDataSetChanged();
                        edit.setText("");
                        Log.d("myLogs", "do");
                        return true;
                    }
                Log.d("myLogs", "not");
                return true;
            }
        });
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                Toast.makeText(getApplicationContext(), ((TextView) itemClicked).getText(),
                        Toast.LENGTH_SHORT).show();
            }
        });
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

    public void onClickBack(View view) {
        Intent intent = new Intent(DictionaryActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void onClickEdit(View view) {
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
        Intent intent = new Intent(DictionaryActivity.this, EditActivity.class);
        startActivity(intent);
    }

    public void onClickDelete(View view) {

        ArrayAdapter<String> adapterlist = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dicts);
        ListView list = (ListView) findViewById(R.id.listView);
        list.setTextFilterEnabled(true);
        list.setAdapter(adapterlist);
        adapterlist.notifyDataSetChanged();
        dicts.remove(0);
        adapterlist.notifyDataSetChanged();


    }

    public void onClickImport(View view) {

    }
}




