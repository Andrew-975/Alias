package com.example.andrew_975.alias.entities;

/**
 * Created by Andrew_975 on 12.05.2015.
 */
public class Parameters {
    public static final int STANDARD_TURN_LENGTH_SECONDS = 60;
    public static final int STANDARD_NUMBER_WORDS_TO_WIN = 30;

    private int _turnLengthSeconds;
    private int _numberWordsToWin;
    Topic _topic;

    // region Constructors
    public Parameters(int turnLengthSeconds, int numberWordsToWin, Topic topic){
        _turnLengthSeconds = turnLengthSeconds;
        _numberWordsToWin = numberWordsToWin;
        _topic = topic;
    }

    Parameters(int inputNumberWordsToWin, Topic topic){
        this(STANDARD_TURN_LENGTH_SECONDS, inputNumberWordsToWin, topic);
    }

    Parameters(Topic topic){
        this(STANDARD_NUMBER_WORDS_TO_WIN, topic);
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