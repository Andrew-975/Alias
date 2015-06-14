package com.example.andrew_975.alias;

import com.example.andrew_975.alias.entities.Game;
import com.example.andrew_975.alias.entities.Team;
import com.example.andrew_975.alias.entities.Topic;

import java.util.ArrayList;

import static com.example.andrew_975.alias.sqlite.TopicQ.getAllSugarTopics;
import static com.example.andrew_975.alias.sqlite.WordQ.getAllSugarWords;

/**
 * Created by Ira on 29.05.2015.
 */
public class Exchange {
    //public static Parameters parametres;
    public static ArrayList<Team> teams;

    public static Game game;

    public static WordStatistic wordStatistic;


    //public static ArrayList<DictionaryForAdd> dicts;
    public static Topic dictionary;
    public static int CurrentTopicId;
    public static int lastTopicId = getAllSugarTopics().size();
    public static int lastWordId = getAllSugarWords().size();

}
