package com.example.andrew_975.alias;

/**
 * Created by Ira on 27.04.2015.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andrew_975.alias.entities.Topic;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrew_975.alias.sqlite.TopicQ.deleteSugarTopic;
import static com.example.andrew_975.alias.sqlite.TopicQ.getAllSugarTopics;

public class MyAdapter extends BaseAdapter implements ListAdapter {
    public ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private boolean editable;

    public MyAdapter(ArrayList<String> list, Context context,boolean editable) {
        this.list = list;
        this.context = context;
        this.editable = editable;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        //Handle TextView and display string from your list
        final TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        final String name = list.get(position);
        listItemText.setText(name);


        //Handle buttons and add onClickListeners
        ImageButton deleteBtn = (ImageButton)view.findViewById(R.id.Delete);

        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                list.remove(position); //or some other task
                if(context instanceof DictionaryActivity) {
                    List<Topic> allTopics = getAllSugarTopics();
                    for(int i = 0;i < allTopics.size();i++) {
                        if (allTopics.get(i).getTopicText().equals(name)) {
                            Topic t = allTopics.get(i);
                            long l = t.getTopicId();
                            deleteSugarTopic(l);
                            Exchange.lastTopicId --;
                            for(int j = 0;j < allTopics.size()-1;j++){

                            }
                        }
                    }

                    Log.v("mylog", "deleted!!");
                }
                notifyDataSetChanged();
            }
        });
        listItemText.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
               if(editable == true) {
                   if(context instanceof DictionaryActivity){
                       ((DictionaryActivity)context).onClickEditAdapter(v, name);
                       if(((DictionaryActivity)context).dicts.size() != 0) {
                           List<Topic> allTopics = getAllSugarTopics();
                           for(int i = 0;i < allTopics.size();i++) {
                               if (allTopics.get(i).getTopicText().equals(name)) {
                                   Topic t = allTopics.get(i);
                                   int l = t.getTopicId();
                                   Exchange.CurrentTopicId = l;
                               }
                           }
                           Exchange.CurrentTopicId = ((DictionaryActivity) context).getTopicfromList(name).getTopicId();
                       }
                   }

               }
            }
                                        }
        );
        return view;
    }
    public String getName(int position)
    {
        return list.get(position);
    }

}

