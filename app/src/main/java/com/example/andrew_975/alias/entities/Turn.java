package com.example.andrew_975.alias.entities;

import com.example.andrew_975.alias.Exchange;

import java.util.ArrayList;
import java.util.List;

import static com.example.andrew_975.alias.sqlite.TopicQ.getAllSugarTopics;
import static com.example.andrew_975.alias.sqlite.TopicQ.getSugarTopic;
import static com.example.andrew_975.alias.sqlite.WordQ.getAllSugarWords;
import static com.example.andrew_975.alias.sqlite.WordQ.getSugarWord;

/**
 * Created by Andrew_975 on 13.05.2015.
 */
public class Turn{
    ArrayList<GameWord> _gameWords;
    Team _team;
    Parametres _parametres;
    int _currWordCount;
    int _statistics;
    int _guessedCount;
    int _unguessedCount;

    public Turn(Team playingTeam, Parametres parametres){
        _team = _team;
        _parametres = parametres;
        _currWordCount = -1;
        _gameWords = new ArrayList<GameWord>();
    }

    public ArrayList<GameWord> getListOfWords(){
        return _gameWords;
    }

    public int countStatistics(){
        int result = 0;

        for(int i = 0; i < _gameWords.size(); i++){
            result += _gameWords.get(i).getGuessedStatus();
        }
        _statistics = result;
        return result;
    }

    public int countNumberOfGuessed(){
        int result = 0;

        for(GameWord gameWord : _gameWords){
            if(gameWord.getIsGuessed()){
                result += 1;
            }
        }
        _guessedCount = result;
        return result;
    }

    public int countNumberOfUnguessed(){
        int result = 0;

        for(GameWord gameWord : _gameWords){
            if(gameWord.getIsUnguessed()){
                result += 1;
            }
        }
        _unguessedCount = result;
        return result;
    }

    public int getStatistics(){
        return _statistics;
    }

    public int getNumberOfGuessed(){
        return _guessedCount;
    }

    public int getNumberOfUnguessed(){
        return _unguessedCount;
    }

    public void start(){
        _gameWords.clear();
        suggestNewWord();
    }

    public void GuessCurrentWord(){
        _gameWords.get(_currWordCount).markGuessed();
        _guessedCount++;
        _statistics += GameWord.GUESSED_STATUS;
        suggestNewWord();
    }

    public void UnguessCurrentWord(){
        _gameWords.get(_currWordCount).markUnguessed();
        _unguessedCount++;
        _statistics += GameWord.UNGUESSED_STATUS;
        suggestNewWord();
    }

    // TODO
    GameWord suggestNewWord(){

        List<Word> allWords = getAllSugarWords();
        Word w = new Word(0, new Description(0, "description"), null, getSugarTopic(Exchange.CurrentTopicId),"�����",false);
        for(int i = 0;i < allWords.size();i++) {
            if (allWords.get(i).getTopic().getTopicId() == Exchange.CurrentTopicId) {
                w = allWords.get(i);
            }
        }
        GameWord result = new GameWord(w,GameWord.NEUTRAL_STATUS);

        return result;
    }

    //void showWord(GameWord inputWord);

    public void stop(){
        _statistics = countStatistics();
    }
}
