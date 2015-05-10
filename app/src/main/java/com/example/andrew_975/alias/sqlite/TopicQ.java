package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.Topic;

/**
 * Created by Yohan on 10.05.2015.
 */
public class TopicQ {
    public static Topic getTopic(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.TOPIC_TABLE_NAME, // a. table
                        new String[]{Constants.TOPIC_ID, Constants.TOPIC_TEXT}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Topic descr = new Topic();
        descr.setTopicId(Integer.parseInt(cursor.getString(0)));
        descr.setTopicText(cursor.getString(1));
        Log.d("getTopic(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }

    public static void insertTopic(Topic word, Context context) {
//for logging
        Log.d("insertTopic", word.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.TOPIC_ID, word.getTopicId()); // get title
        values.put(Constants.TOPIC_TEXT, word.getTopicText());
        db.insert(Constants.TOPIC_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }
}
