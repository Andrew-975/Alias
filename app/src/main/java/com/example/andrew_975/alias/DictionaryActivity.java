package com.example.andrew_975.alias;

import java.util.ArrayList;

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
import android.view.View.OnKeyListener;
import android.util.Log;




public class DictionaryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        ListView list = (ListView) findViewById(R.id.listView);
        final String[] dictArray = {"Science", "Art", "My Dictionary 1", "My Dictionary 2", "My Dictionary 3"};

        final EditText edit = (EditText) findViewById(R.id.editText);

        final ArrayList<String> dicts = new ArrayList<String>();
        for (int i = 0; i < dictArray.length; i++) {
            dicts.add(dictArray[i]);
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dicts);
        list.setAdapter(adapter);
        edit.setOnKeyListener(new OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                Log.d("myLogs", "here");
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                if (keyCode == KeyEvent.KEYCODE_0) { //enter
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
        Intent intent = new Intent(DictionaryActivity.this, EditActivity.class);
        startActivity(intent);
    }

}



   /* ListView lv;
    ArrayList<String> data;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<String>();
        for (int i = 1; i < dictArray.length; i++) {
            data.add(dictArray[i]);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, data);

        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);
    }

    public void onAddButtonClick(View v) {
        data.add("kokoko");

    }

    @Override
    public boolean onDeleteButtonClick() {
        lvSimple.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                int pos = position;
            }
        });

        if (item.getItemId() == CM_DELETE_ID) {
            // �������� ���� � ������ ������
            AdapterContextMenuInfo acmi = (AdapterContextMenuInfo) item.getMenuInfo();
            // ������� Map �� ���������, ��������� ������� ������ � ������
            data.remove(acmi.position);
            // ����������, ��� ������ ����������
            sAdapter.notifyDataSetChanged();
            return true;
        }
        return super.onContextItemSelected(item);
    }*/




