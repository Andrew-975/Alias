package com.example.andrew_975.alias.entities;

import java.util.ArrayList;

/**
 * Created by Andrew_975 on 12.05.2015.
 */
public class Game{
    ArrayList<Team> _teams;
    Parametres _parametres;
    ArrayList<Round> _rounds;
    int _roundCount;
    int[] _statistics;

    public Game(ArrayList<Team> teams, Parametres parametres){
        _teams = teams;
        _parametres = parametres;
        _rounds = new ArrayList<Round>();
        _roundCount = -1;
        _statistics = new int[_teams.size()];
    }

    public int[] countStatistics(){
        int[] result = new int[_teams.size()];

        for(int team = 0; team < _teams.size(); team++){
            int sum = 0;
            for(int round = 0; round < _rounds.size(); round++){
                sum += _rounds.get(round).countStatistics()[team];
            }
            result[team] = sum;
        }
        _statistics = result;
        return result;
    }

    public int[] getStatitstics(){
        return _statistics;
    }

    public Round getCurrentRound(){
        if((_roundCount >= _rounds.size()) || (_roundCount < 0)){
            return null;
        }
        return _rounds.get(_roundCount);
    }

    private boolean addToStatistics(int[] roundStatistics){
        if (roundStatistics.length != _statistics.length){
            return false;
        }

        for(int team = 0; team < _teams.size(); team++){
            _statistics[team] += roundStatistics[team];
        }
        return true;
    }

    public void start(){
        startNewRound();
    }

    private boolean startNewRound(){
        if(isTimeToStop()){
            return false;
        }

        Round round = new Round(_teams, _parametres);
        _rounds.add(round);
        round.start();
        _roundCount++;
        return true;
    }

    private boolean stopCurrentRound(){
        Round round = getCurrentRound();

        if(round == null){
            return false;
        }
        round.stop();
        //
        return true;
    }

    boolean isTimeToStop(){
        return determineWinnerIndex() != -1;
    }

    public void stop(){
        stopCurrentRound();
        countStatistics();
    }

    public int determineWinnerIndex(){
        for(int team = 0; team < _teams.size(); team++){
            if(_statistics[team] >= _parametres.getNumberWordsToWin()){
                return team;
            }
        }
        return -1;
    }

    public String determineWinnerName(){
        int index = determineWinnerIndex();

        if(index == -1){
            return "";
        }
        return _teams.get(index).getTemName();
    }
}