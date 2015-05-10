package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.Team;

/**
 * Created by Yohan on 10.05.2015.
 */
public class TeamQ {
    public static Team getTeam(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.TEAM_TABLE_NAME, // a. table
                        new String[]{Constants.TEAM_ID, Constants.TEAM_NAME, Constants.TEAM_POINTS}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        Team descr = new Team();
        descr.setTeamId(Integer.parseInt(cursor.getString(0)));
        descr.setTemName(cursor.getString(1));
        descr.setPoints(Integer.parseInt(cursor.getString(2)));
        Log.d("getPG(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }

    public static void insertTeam(Team team, Context context) {
        //for logging
        Log.d("insertTeam", team.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.TEAM_ID, team.getTeamId()); // get title
        values.put(Constants.TEAM_NAME, team.getTemName());
        values.put(Constants.TEAM_POINTS, team.getPoints());
        db.insert(Constants.TEAM_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }
}
