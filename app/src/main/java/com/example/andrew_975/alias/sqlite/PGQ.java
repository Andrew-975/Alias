package com.example.andrew_975.alias.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.andrew_975.alias.entities.*;
import com.example.andrew_975.alias.sqlite.TeamQ;
import com.example.andrew_975.alias.sqlite.WordQ;

import java.sql.Date;

/**
 * Created by Yohan on 10.05.2015.
 */
public class PGQ {
    public static PlayedGames getPG(int id, Context context) {
        SQLiteDatabase db = new Database(context).getReadableDatabase();
        Cursor cursor =
                db.query(Constants.PG_TABLE_NAME, // a. table
                        new String[]{Constants.PG_ID, Constants.WORD_ID, Constants.TEAM_ID, Constants.PG_DATE}, // b. column names
                        " id = ?", // c. selections
                        new String[]{String.valueOf(id)}, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit
        if (cursor != null)
            cursor.moveToFirst();
        PlayedGames descr = new PlayedGames();
        descr.setPgId(Integer.parseInt(cursor.getString(0)));
        descr.setTeam(TeamQ.getTeam(Integer.parseInt(cursor.getString(2)), context));
        descr.setWord(WordQ.getWord(Integer.parseInt(cursor.getString(1)), context));
        descr.setPlayedDate(new Date(Integer.parseInt(cursor.getString(3))));
        Log.d("getPG(" + id + ")", descr.toString());
        if (db != null && db.isOpen())
            db.close();
        return descr;
    }

    public static void insertPG(PlayedGames pg, Context context) {
        //for logging
        Log.d("insertPG", pg.toString());
        SQLiteDatabase db = new Database(context).getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.PG_ID, pg.getPgId()); // get title
        values.put(Constants.WORD_ID, pg.getWord().getWordId());
        values.put(Constants.TEAM_ID, pg.getTeam().getTeamId());
        values.put(Constants.PG_DATE, pg.getPlayedDate().getTime());
        db.insert(Constants.PG_TABLE_NAME, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values
        db.close();
    }

    public static void insertSugarPG(PlayedGames descr) {
        descr.save();
    }

    public static PlayedGames getSugarPG(long id) {
        PlayedGames description = PlayedGames.findById(PlayedGames.class,id);
        return description;
    }

    public static void updateSugarPG(PlayedGames description) {
        PlayedGames oldDescr = PlayedGames.findById(
                PlayedGames.class,(long)description.getPgId());
        oldDescr.setWord(description.getWord());
        oldDescr.setPlayedDate(description.getPlayedDate());
        oldDescr.setTeam(description.getTeam());
        oldDescr.save();
    }

    public static void deleteSugarPlayedGames(long id) {
        PlayedGames description = PlayedGames.findById(PlayedGames.class,id);
        description.delete();
    }
}
