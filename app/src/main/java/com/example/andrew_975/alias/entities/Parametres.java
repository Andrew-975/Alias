package com.example.andrew_975.alias.entities;

/**
 * Created by Andrew_975 on 12.05.2015.
 */
public class Parametres{
    public static final int STANDARD_TURN_LENGTH_SECONDS = 60;
    public static final int STANDARD_NUMbER_WORDS_TO_WIN = 60;

    private int _turnLengthSeconds;
    private int _numberWordsToWin;
    Topic _topic;

    // region Constructors
    public Parametres(int turnLengthSeconds, int numberWordsToWin, Topic topic){
        _turnLengthSeconds = turnLengthSeconds;
        _numberWordsToWin = numberWordsToWin;
        _topic = topic;
    }

    Parametres(int inputNumberWordsToWin, Topic topic){
        this(STANDARD_TURN_LENGTH_SECONDS, inputNumberWordsToWin, topic);
    }

    Parametres(Topic topic){
        this(STANDARD_NUMbER_WORDS_TO_WIN, topic);
    }
    //endregion

    public int getTurnLengthSeconds(){
        return _turnLengthSeconds;
    }

    public int getNumberWordsToWin(){
        return _numberWordsToWin;
    }

    public Topic gerTopic(){
        return _topic;
    }
}