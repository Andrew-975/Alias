package com.example.andrew_975.alias;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;


public class AddDictActivity extends ActionBarActivity {

    //ArrayList<String> words = new ArrayList(Arrays.asList("My Pants", "Shorts", "Pantalony", "Retuses", "Kobinatsiya"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dict);

        Resources res = getResources();
        final ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words, res.getStringArray(R.array.words));
        final ListView list1 = (ListView) findViewById(R.id.editList);
        final EditText edit1 = (EditText) findViewById(R.id.editTextDel);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        list1.setAdapter(adapter1);
        edit1.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if (keyCode == KeyEvent.KEYCODE_0) {
                        words.add(0, edit1.getText().toString());
                        adapter1.notifyDataSetChanged();
                        edit1.setText("");
                        return true;
                    }
                return false;
            }
        });

    }

    /*public View getView(final int position, View convertView, ViewGroup parent, Context context, ListView list) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        //Handle TextView and display string from your list
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position));

        //Handle buttons and add onClickListeners
        ImageButton deleteBtn = (ImageButton)view.findViewById(R.id.Delete);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                notifyDataSetChanged();
            }
        });*/



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

    public void onClickDelete(View view) {
        Resources res = getResources();
        ArrayList<String> words = new ArrayList<String>();
        Collections.addAll(words, res.getStringArray(R.array.add_dictionaries));
        ArrayAdapter<String> adapterlist = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, words);
        ListView list = (ListView) findViewById(R.id.editList);
        list.setTextFilterEnabled(true);
        list.setAdapter(adapterlist);
        adapterlist.notifyDataSetChanged();
        words.remove(0);
        adapterlist.notifyDataSetChanged();
    }

    public void onClickBackToDict(View view) {
        Intent intent = new Intent(AddDictActivity.this, DictionaryActivity.class);
        startActivity(intent);
    }
}
