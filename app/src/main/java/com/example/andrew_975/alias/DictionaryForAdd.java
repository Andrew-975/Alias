package com.example.andrew_975.alias;

import java.util.ArrayList;

/**
 * Created by Ira on 02.06.2015.
 */
public class DictionaryForAdd {
    private String name;
    private ArrayList<String> words;

    public DictionaryForAdd(String name,ArrayList<String> words){
        this.name = name;
        this.words = words;
    }
    public DictionaryForAdd(String name){
        this.name = name;
        this.words = null;
    }
    public String getName(){
        return name;
    }

}
