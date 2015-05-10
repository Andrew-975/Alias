package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.*;
import com.example.andrew_975.alias.sqlite.TopicQ;
import com.example.andrew_975.alias.sqlite.DescrQ;
import com.example.andrew_975.alias.sqlite.LevelQ;

/**
 * Created by Yohan on 10.05.2015.
 */
public class WordQ {
    public static Word getWord(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.WORD_TABLE_NAME, // a. table
                        new String[]{Constants.WORD_ID, Constants.WORD_TEXT, Constants.WORD_IS_DEFAULT,
                                Constants.DESCRIPTION_ID, Constants.LEVEL_ID, Constants.TOPIC_ID}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Word descr = new Word();
        descr.setWordId(Integer.parseInt(cursor.getString(0)));
        descr.setWordText(cursor.getString(1));
        descr.setDef(Boolean.parseBoolean(cursor.getString(2)));
        descr.setDescr(DescrQ.getDescription(Integer.parseInt(cursor.getString(3)), context));
        descr.setLevel(LevelQ.getLevel(Integer.parseInt(cursor.getString(4)), context));
        descr.setTopic(TopicQ.getTopic(Integer.parseInt(cursor.getString(5)), context));
        Log.d("getWord(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }

    public static void insertWord(Word word, Context context) {
//for logging
        Log.d("insertWord", word.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.WORD_ID, word.getWordId()); // get title
        values.put(Constants.WORD_TEXT, word.getWordText());
        values.put(Constants.WORD_IS_DEFAULT, Boolean.toString(word.isDef));
        values.put(Constants.DESCRIPTION_ID, word.getDescr().getDescrId());
        values.put(Constants.LEVEL_ID, word.getLevel().getLevelId());
        values.put(Constants.TOPIC_ID, word.getTopic().getTopicId());
        db.insert(Constants.WORD_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }
}
