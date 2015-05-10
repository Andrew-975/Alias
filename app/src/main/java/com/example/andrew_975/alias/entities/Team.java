package com.example.andrew_975.alias.entities;

/**
 * Created by Yohan on 10.05.2015.
 */
public class Team {
    private int teamId;

    private String temName;

    private int points;

    public Team(int teamId,String temName,int points) {
        this.teamId = teamId;
        this.points = points;
        this.temName = temName;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setTemName(String temName) {
        this.temName = temName;
    }

    public int getTeamId() {
        return teamId;
    }

    public int getPoints() {
        return points;
    }

    public String getTemName() {
        return temName;
    }
}
