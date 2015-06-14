package com.example.andrew_975.alias.entities;

import com.orm.SugarRecord;

import java.util.Date;

/**
 * Created by Yohan on 10.05.2015.
 */
public class PlayedGames extends SugarRecord<PlayedGames>{
    private int pgId;

    private Word word;

    private Team team;

    private Date playedDate;

    public PlayedGames() {

    }

    public PlayedGames(int pgId,Word wordId, Team teamId, Date playedDate) {
        this.pgId = pgId;
        this.playedDate = playedDate;
        this.team = teamId;
        this.word = wordId;
    }

    public void setPgId(int pgId) {
        this.pgId = pgId;
    }

    public void setPlayedDate(Date playedDate) {
        this.playedDate = playedDate;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void setWord(Word wordId) {
        this.word = wordId;
    }

    public Date getPlayedDate() {
        return playedDate;
    }

    public int getPgId() {
        return pgId;
    }

    public Team getTeam() {
        return team;
    }

    public Word getWord() {
        return word;
    }
}
