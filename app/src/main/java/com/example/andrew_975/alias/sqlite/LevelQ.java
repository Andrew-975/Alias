package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.Level;

/**
 * Created by Yohan on 10.05.2015.
 */
public class LevelQ {
    public static Level getLevel(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.LEVEL_TABLE_NAME, // a. table
                        new String[]{Constants.LEVEL_ID, Constants.LEVEL_NUMBER, Constants.LEVEL_NAME}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Level descr = new Level();
        descr.setLevelId(Integer.parseInt(cursor.getString(0)));
        descr.setLevelName(cursor.getString(2));
        descr.setLevelNumber(Integer.parseInt(cursor.getString(1)));
        Log.d("getLevel(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }

    public static void insertlevel(Level level, Context context) {
        //for logging
        Log.d("insertlevel", level.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.LEVEL_ID, level.getLevelId()); // get title
        values.put(Constants.LEVEL_NAME, level.getLevelName());
        values.put(Constants.LEVEL_NUMBER, level.getLevelNumber());
        db.insert(Constants.LEVEL_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }
    public static void deleteLevel(Level book, Context context) {
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        db.delete(Constants.LEVEL_TABLE_NAME, //table name
                Constants.LEVEL_ID+" = ?",  // selections
                new String[] { String.valueOf(book.getLevelId()) }); //selections args
        db.close();
        //log
        Log.d("deleteWord", book.toString());
    }

    public static int updateLevel(Level level, Context context) {

        // 1. get reference to writable DB
        SQLiteDatabase db = new Database(context).getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(Constants.LEVEL_ID, level.getLevelId()); // get title
        values.put(Constants.LEVEL_NAME, level.getLevelName());
        values.put(Constants.LEVEL_NUMBER, level.getLevelNumber());

        // 3. updating row
        int i = db.update(Constants.LEVEL_TABLE_NAME, //table
                values, // column/value
                Constants.LEVEL_ID+" = ?", // selections
                new String[] { String.valueOf(level.getLevelId()) }); //selection args

        // 4. close
        db.close();

        return i;

    }

    public static void insertSugarLevel(Level descr) {
        descr.save();
    }

    public static Level getSugarLevel(long id) {
        Level description = Level.findById(Level.class,id);
        return description;
    }

    public static void updateSugarLevel(Level description) {
        Level oldDescr = Level.findById(
                Level.class,(long)description.getLevelId());
        oldDescr.setLevelName(description.getLevelName());
        oldDescr.setLevelNumber(description.getLevelNumber());
        oldDescr.save();
    }

    public static void deleteSugarLevel(long id) {
        Level description = Level.findById(Level.class,id);
        description.delete();
    }
}
