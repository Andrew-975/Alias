package com.example.andrew_975.alias.entities;

import java.util.ArrayList;

/**
 * Created by Andrew_975 on 13.05.2015.
 */
public class Round{
    ArrayList<Team> _teams;
    Parametres _parametres;
    ArrayList<Turn> _turns;
    int _turnCount;
    int[] _statistics;

    public Round(ArrayList<Team> teams, Parametres parametres){
        _teams = teams;
        _parametres = parametres;
        _turnCount = -1;
        _turns = new ArrayList<Turn>();
        _statistics = new int[_teams.size()];
    }

    public int[] countStatistics(){
        int i = 0;
        int[] result = new int[_teams.size()];

        while(i < _turnCount){
            result[i] = _turns.get(i).countStatistics();
        }
        _statistics = result;
        return result;
    }

    public int[] getStatistics(){
        return _statistics;
    }

    public Turn getCurrentTurn(){
        if((_turnCount >= _turns.size()) || (_turnCount < 0)){
            return null;
        }
        return _turns.get(_turnCount);
    }

    private boolean isTimeToStop(){
        return _turnCount == _teams.size() - 1;
    }

    public void start(){
        while (!isTimeToStop()){
            newTurn();
        }
        stop();
    }

    public boolean newTurn(){
        stopCurrentTurn();
        return startNewTurn();
    }

    private boolean startNewTurn(){
        _turnCount++;
        if((_turnCount >= _teams.size()) || (_turnCount < 0)){
            return false;
        }
        Turn currTurn = new Turn(_teams.get(_turnCount), _parametres);
        _turns.add(currTurn);
        currTurn.start();
        return true;
    }

    private boolean stopCurrentTurn(){
        Turn turn = getCurrentTurn();

        if(turn == null){
            return false;
        }
        turn.stop();
        _statistics[_turnCount] = turn.countStatistics();
        return true;
    }

    public void stop(){
        stopCurrentTurn();
        countStatistics();
    }
}