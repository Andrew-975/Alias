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
    private Context context;
    private boolean editable;
    public int stat;

    public InteractiveArrayAdapter (Context context,boolean editable) {
        this.context = context;
        this.editable = editable;
    }

    @Override
    public int getCount() {
        return Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().size();
    }

    @Override
    public Object getItem(int pos) {
        return Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().get(pos);
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
        final GameWord elem = Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().get(position);
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
                if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == 1){
                    return;
                }
                else if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == -1)
                {
                    Exchange.game.getCurrentTurn().getListOfWords().get(position).markGuessed();
                    Exchange.wordStatistic.changeVal(2);
                    return;
                }
                Exchange.game.getCurrentTurn().getListOfWords().get(position).markGuessed();
                Exchange.wordStatistic.changeVal(1);
//TODO change pic
                notifyDataSetChanged();
            }
        });
        falseBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == -1){
                    return;
                }
                else if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == 1)
                {
                    Exchange.game.getCurrentTurn().getListOfWords().get(position).markUnguessed();
                    Exchange.wordStatistic.changeVal(-2);
                    return;
                }
                Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().get(position).markUnguessed();
                Exchange.wordStatistic.changeVal(-1);
//TODO change pic
                notifyDataSetChanged();
            }
        });
        newtBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //do something
                if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == 0){
                    return;
                }
                else if(Exchange.game.getCurrentTurn().getListOfWords().get(position).getGuessedStatus() == -1)
                {
                    Exchange.game.getCurrentTurn().getListOfWords().get(position).markNeutral();
                    Exchange.wordStatistic.changeVal(1);
                    return;
                }
                Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().get(position).markNeutral();
                Exchange.wordStatistic.changeVal(-1);
//TODO change pic
                notifyDataSetChanged();
            }
        });

        return view;
    }
    public String getName(int position)
    {
        return Exchange.game.getCurrentRound().getCurrentTurn().getListOfWords().get(position).getInLowercase();
    }

}

