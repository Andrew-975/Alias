package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.Description;

/**
 * Created by Yohan on 10.05.2015.
 */
public class DescrQ {

    public static void insertDescription(Description descr, Context context) {
        //for logging
        Log.d("insertDescription", descr.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.DESCRIPTION_ID, descr.getDescrId()); // get title
        values.put(Constants.DESCRIPTION_TEXT, descr.getDescrText()); // get author
        db.insert(Constants.DESCRIPTION_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }

    public static Description getDescription(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.DESCRIPTION_TABLE_NAME, // a. table
                        new String[]{Constants.DESCRIPTION_ID, Constants.DESCRIPTION_TEXT}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Description descr = new Description();
        descr.setDescrId(Integer.parseInt(cursor.getString(0)));
        descr.setDescrText(cursor.getString(1));
        Log.d("getDescription(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }
    public static void deleteDescription(Description book, Context context) {
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        db.delete(Constants.DESCRIPTION_TABLE_NAME, //table name
                Constants.DESCRIPTION_ID+" = ?",  // selections
                new String[] { String.valueOf(book.getDescrId()) }); //selections args
        db.close();
        //log
        Log.d("deleteWord", book.toString());
    }

    public static int updateDescription(Description descr, Context context) {

        // 1. get reference to writable DB
        SQLiteDatabase db = new Database(context).getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(Constants.DESCRIPTION_ID, descr.getDescrId()); // get title
        values.put(Constants.DESCRIPTION_TEXT, descr.getDescrText());

        // 3. updating row
        int i = db.update(Constants.DESCRIPTION_TABLE_NAME, //table
                values, // column/value
                Constants.DESCRIPTION_ID+" = ?", // selections
                new String[] { String.valueOf(descr.getDescrId()) }); //selection args

        // 4. close
        db.close();

        return i;
    }

    public static void insertSugarDescr(Description descr) {
        descr.save();
    }

    public static Description getSugarDescr(long id) {
        Description description = Description.findById(Description.class,id);
        return description;
    }

    public static void updateSugarDescription(Description description) {
        Description oldDescr = Description.findById(
                Description.class,(long)description.getDescrId());
        oldDescr.setDescrText(description.getDescrText());
        oldDescr.save();
    }

    public static void deleteSugarDescription(long id) {
        Description description = Description.findById(Description.class,id);
        description.delete();
    }

}
