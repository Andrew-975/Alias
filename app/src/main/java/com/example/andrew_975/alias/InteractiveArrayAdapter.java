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

import com.example.andrew_975.alias.entities.GameWord;
import com.example.andrew_975.alias.entities.Topic;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrew_975.alias.sqlite.TopicQ.deleteSugarTopic;
import static com.example.andrew_975.alias.sqlite.TopicQ.getAllSugarTopics;

public class InteractiveArrayAdapter extends BaseAdapter implements ListAdapter {
    public ArrayList<GameWord> list;
    private Context context;
    private boolean editable;

    public InteractiveArrayAdapter (ArrayList<GameWord> list, Context context,boolean editable) {
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
            view = inflater.inflate(R.layout.rowlayoutstatistic, null);
        }

        //Handle TextView and display string from your list
        final TextView listItemView = (TextView)view.findViewById(R.id.list_item_string_statistic);
        final GameWord elem = list.get(position);
        listItemView.setText(elem.getInLowercase());

        //setImages
        switch (elem.getGuessedStatus()) {
            case 1:
                break;
            case -1:
                break;
            default:
                break;
        }


        //Handle buttons and add onClickListeners
        ImageButton trBtn = (ImageButton)view.findViewById(R.id.tr);
        ImageButton falseBtn = (ImageButton)view.findViewById(R.id.fal);
        ImageButton newtBtn = (ImageButton)view.findViewById(R.id.newt);

        trBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                //list.get(position).setStatus(1);
                if(context instanceof DictionaryActivity) {
                    List<Topic> allTopics = getAllSugarTopics();
                    for(int i = 0;i < allTopics.size();i++) {
                        if (allTopics.get(i).getTopicText().equals(elem)) {
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
        falseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                //list.get(position).setStatus(-1);
                if(context instanceof DictionaryActivity) {
                    List<Topic> allTopics = getAllSugarTopics();
                    for(int i = 0;i < allTopics.size();i++) {
                        if (allTopics.get(i).getTopicText().equals(elem)) {
                            Topic t = allTopics.get(i);
                            long l = t.getTopicId();
                            deleteSugarTopic(l);
                            //Exchange.game.getCurrentRound().getCurrentTurn().setcountNumberOfUnguessed(Exchange.game.getCurrentRound().getCurrentTurn().countNumberOfGuessed());
                            for(int j = 0;j < allTopics.size()-1;j++){

                            }
                        }
                    }

                    Log.v("mylog", "deleted!!");
                }
                notifyDataSetChanged();
            }
        });
        newtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                //list.get(position).setStatus(0);
                if(context instanceof DictionaryActivity) {
                    List<Topic> allTopics = getAllSugarTopics();
                    for(int i = 0;i < allTopics.size();i++) {
                        if (allTopics.get(i).getTopicText().equals(elem)) {
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
        /*listItemText.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                                if(editable == true) {
                                                    if(context instanceof DictionaryActivity){
                                                        ((DictionaryActivity)context).onClickEditAdapter(v, name.getName());
                                                        if(((DictionaryActivity)context).dicts.size() != 0) {
                                                            List<Topic> allTopics = getAllSugarTopics();
                                                            for(int i = 0;i < allTopics.size();i++) {
                                                                if (allTopics.get(i).getTopicText().equals(name)) {
                                                                    Topic t = allTopics.get(i);
                                                                    int l = t.getTopicId();
                                                                    Exchange.CurrentTopicId = l;
                                                                }
                                                            }
                                                            Exchange.CurrentTopicId = ((DictionaryActivity) context).getTopicfromList(name.getName()).getTopicId();
                                                        }
                                                    }

                                                }
                                            }
                                        }
        );*/
        return view;
    }
    public String getName(int position)
    {
        //return list.get(position).getName();
    }

}

