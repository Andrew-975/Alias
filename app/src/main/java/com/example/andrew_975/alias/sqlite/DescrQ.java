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
}
