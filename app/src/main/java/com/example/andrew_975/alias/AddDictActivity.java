package com.example.andrew_975.alias;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;


public class AddDictActivity extends ActionBarActivity {

    ArrayList<String> words = new ArrayList(Arrays.asList("My Pants", "Shorts", "Pantalony", "Retuses", "Kobinatsiya"));
    float historicX = Float.NaN, historicY = Float.NaN;
    static final int DELTA = 50;
    //enum Direction {LEFT, RIGHT;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dict);
        ListView list1 = (ListView) findViewById(R.id.editList);
        final EditText edit1 = (EditText) findViewById(R.id.editTextAdd);
        final ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        list1.setAdapter(adapter1);

        list1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // TODO Auto-generated method stub
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        historicX = event.getX();
                        historicY = event.getY();
                        break;

                    case MotionEvent.ACTION_UP:
                        if (event.getX() - historicX < -DELTA) {


                            return true;
                        } else if (event.getX() - historicX > DELTA) {
                            //FunctionDeleteRowWhenSlidingRight();
                            return true;
                        }
                        break;
                    default:
                        return false;
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
