package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

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
                db.rawQuery("select * from Word,Description,Level,Topic Where wordId = ? " +
                        "AND Word.descrId = Description.descrId AND Word.topicId " +
                        "= Topic.topicId AND Word.levelId = Level.levelId ", new String[]{String.valueOf(id)});
        if (cursor != null)
            cursor.moveToFirst();
        Word descr = new Word();
        descr.setWordId(cursor.getInt(cursor.getColumnIndex(Constants.WORD_ID)));
        descr.setWordText(cursor.getString(cursor.getColumnIndex(Constants.WORD_TEXT)));
        descr.setDef(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(Constants.WORD_IS_DEFAULT))));

        descr.setDescr(new Description(cursor.getInt(cursor.getColumnIndex(Constants.DESCRIPTION_ID)),
                cursor.getString(cursor.getColumnIndex(Constants.DESCRIPTION_TEXT))));

        descr.setLevel(new Level(cursor.getInt(cursor.getColumnIndex(Constants.LEVEL_ID)),
                cursor.getString(cursor.getColumnIndex(Constants.LEVEL_NAME)),
                cursor.getInt(cursor.getColumnIndex(Constants.LEVEL_NUMBER))));

        descr.setTopic(new Topic(cursor.getInt(cursor.getColumnIndex(Constants.TOPIC_ID)),
                cursor.getString(cursor.getColumnIndex(Constants.TOPIC_TEXT))));
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

    public static List<Word> getAllWords() {
        List<Word> wordList = new ArrayList<Word>();

        return wordList;
    }
}
