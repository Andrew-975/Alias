package com.example.andrew_975.alias.entities;

import java.util.Date;

/**
 * Created by Yohan on 10.05.2015.
 */
public class PlayedGames {
    private int pgId;

    private Word word;

    private int teamId;

    private Date playedDate;

    public PlayedGames(int pgId,Word wordId, int teamId, Date playedDate) {
        this.pgId = pgId;
        this.playedDate = playedDate;
        this.teamId = teamId;
        this.word = wordId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    public void setPlayedDate(Date playedDate) {
        this.playedDate = playedDate;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setWordId(Word wordId) {
        this.word = wordId;
    }

    public Date getPlayedDate() {
        return playedDate;
    }

    public int getPgId() {
        return pgId;
    }

    public int getTeamId() {
        return teamId;
    }

    public Word getWordId() {
        return word;
    }
}
