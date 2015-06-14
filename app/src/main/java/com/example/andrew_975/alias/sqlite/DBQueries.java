package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.util.Log;

import com.example.andrew_975.alias.entities.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Yohan on 10.05.2015.
 */
public abstract class DBQueries {
    public static final String CREATE_DESCRIPTION_TABLE = "create table IF NOT EXISTS Description ("
            + Constants.DESCRIPTION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.DESCRIPTION_TEXT + " TEXT NOT NULL);";

    public static final String CREATE_lEVEL_TABLE = "create table IF NOT EXISTS Level ("
            + Constants.LEVEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.LEVEL_NAME + " TEXT NOT NULL,"
            + Constants.LEVEL_NUMBER + " INTEGER NOT NULL);";

    public static final String CREATE_TEAM_TABLE = "create table IF NOT EXISTS Team ("
            + Constants.TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.TEAM_NAME + " TEXT NOT NULL,"
            + Constants.TEAM_POINTS + " INTEGER NOT NULL);";

    public static final String CREATE_PG_TABLE = "create table IF NOT EXISTS " + Constants.PG_TABLE_NAME + " ("
            + Constants.PG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.WORD_ID + " INTEGER, "
            + Constants.TEAM_ID + " INTEGER, "
            + Constants.PG_DATE + " INTEGER NOT NULL, "
            + " FOREIGN KEY " + Constants.WORD_ID + " REFERENCES Word(" + Constants.WORD_ID + "),"
            + " FOREIGN KEY " + Constants.TEAM_ID + " REFERENCES Team(" + Constants.TEAM_ID + "));";

    public static final String CREATE_TOPIC_TABLE = "create table IF NOT EXISTS Topic ("
            + Constants.TOPIC_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.TOPIC_TEXT + " TEXT NOT NULL)";

    public static final String CREATE_WORD_TABLE = "create table IF NOT EXISTS " + Constants.WORD_TABLE_NAME + " ("
            + Constants.WORD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + Constants.DESCRIPTION_ID + " INTEGER, "
            + Constants.LEVEL_ID + " INTEGER,"
            + Constants.TOPIC_ID + " INTEGER,"
            + Constants.WORD_TEXT + " TEXT NOT NULL,"
            + Constants.WORD_IS_DEFAULT + " TEXT NOT NULL, "
            + " FOREIGN KEY " + Constants.DESCRIPTION_ID + " REFERENCES Description(" + Constants.DESCRIPTION_ID + "),"
            + " FOREIGN KEY " + Constants.LEVEL_ID + " REFERENCES Level(" + Constants.LEVEL_ID + "),"
            + " FOREIGN KEY " + Constants.TOPIC_ID + " REFERENCES Topic(" + Constants.TOPIC_ID + ");";

    public static void createAllTables(SQLiteDatabase db) {
        db.execSQL(CREATE_DESCRIPTION_TABLE);
        db.execSQL(CREATE_lEVEL_TABLE);
        db.execSQL(CREATE_TEAM_TABLE);
        db.execSQL(CREATE_PG_TABLE);
        db.execSQL(CREATE_TOPIC_TABLE);
        db.execSQL(CREATE_WORD_TABLE);
    }

    public static void deleteAllTables(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + Constants.WORD_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.PG_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.DESCRIPTION_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.LEVEL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TEAM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + Constants.TOPIC_TABLE_NAME);
    }

}
