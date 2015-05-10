package com.example.andrew_975.alias.entities;

/**
 * Created by Yohan on 10.05.2015.
 */
public class Word {
    private int wordId;

    private Description descr;

    private Level level;

    private Topic topic;

    private String wordText;

    private boolean isDefault;

    public Word(int wordId,Description descr,Level level,Topic topic,String wordText,boolean isDefault) {
        setDefault(isDefault);
        setDescr(descr);
        setLevel(level);
        setTopic(topic);
        setWordId(wordId);
        setWordText(wordText);
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public void setDescr(Description descr) {
        this.descr = descr;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public void setWordText(String wordText) {
        this.wordText = wordText;
    }

    public int getWordId() {
        return wordId;
    }

    public Description getDescr() {
        return descr;
    }

    public Level getLevel() {
        return level;
    }

    public String getWordText() {
        return wordText;
    }

    public Topic getTopic() {
        return topic;
    }
}
