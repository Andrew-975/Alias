package com.example.andrew_975.alias.sqlite;

import android.provider.BaseColumns;

/**
 * Created by Yohan on 10.05.2015.
 */
public abstract class Constants {
    //Word
    public static final String WORD_TABLE_NAME= "Word";
    public static final String WORD_ID = "wordId";
    public static final String WORD_TEXT = "wordText";
    public static final String WORD_IS_DEFAULT = "idDefault";
    //Description
    public static final String DESCRIPTION_TABLE_NAME= "Description";
    public static final String DESCRIPTION_ID = "descrId";
    public static final String DESCRIPTION_TEXT = "descrText";
    //Topic
    public static final String TOPIC_TABLE_NAME= "Topic";
    public static final String TOPIC_ID = "topicId";
    public static final String TOPIC_TEXT= "topicText";
    //Level
    public static final String LEVEL_TABLE_NAME= "Level";
    public static final String LEVEL_ID = "levelId";
    public static final String LEVEL_NAME = "levelName";
    public static final String LEVEL_NUMBER = "levelNumber";
    //PlayedGames
    public static final String PG_TABLE_NAME= "PlayedGames";
    public static final String PG_ID = "pgId";
    public static final String PG_DATE = "pgDate";
    //Team
    public static final String TEAM_TABLE_NAME= "Team";
    public static final String TEAM_ID = "teamId";
    public static final String TEAM_NAME = "teamName";
    public static final String TEAM_POINTS = "points";


}
