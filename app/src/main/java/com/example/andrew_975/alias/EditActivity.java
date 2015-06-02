package com.example.andrew_975.alias;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class EditActivity extends ActionBarActivity {


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
        Toast.makeText(getApplicationContext(), "Add",
                Toast.LENGTH_SHORT).show();
        EditText edit = (EditText) findViewById(R.id.editTextAdd);
        edit.setText("");
    }

    public void onClickDel(View view) {
        Toast.makeText(getApplicationContext(), "Delete",
                Toast.LENGTH_SHORT).show();
        EditText edit = (EditText) findViewById(R.id.addWords);
        edit.setText("");
    }


    public void setName(String name)
    {
        TextView t = (TextView) findViewById(R.id.editName);
        t.setText(name);
    }
}
