package com.example.andrew_975.alias.entities;

/**
 * Created by Yohan on 10.05.2015.
 */
public class Topic {
    private int topicId;

    private String topicText;

    public Topic() {

    }

    public Topic(int topicId,String topicText) {
        setTopicId(topicId);
        setTopicText(topicText);
    }
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setTopicText(String topicText) {
        this.topicText = topicText;
    }

    public int getTopicId() {
        return topicId;
    }

    public String getTopicText() {
        return topicText;
    }
}
