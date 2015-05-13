package com.example.andrew_975.alias.entities;

/**
 * Created by Andrew_975 on 13.05.2015.
 */
public class GameWord{
    public static final int GUESSED_STATUS = 1;
    public static final int NEUTRAL_STATUS = 0;
    public static final int UNGUESSED_STATUS = -1;

    Word _word;
    int _guessedStatus;

    public GameWord(Word inputWord, int guessedStatus){
        _word = _word;
        _guessedStatus = guessedStatus;
    }
    public GameWord(Word word){
        this(word, NEUTRAL_STATUS);
    }

//    public String ToLowerCase(String input){
//        StringBuffer resultWord = new StringBuffer();
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//
//            if (Character.isUpperCase(c)) {
//                // Change particular uppercase char with its lowercase analog.
//                if ((int) c < (int) 'z') {
//                    // Letter is Latin.
//                    resultWord.append((char) (c - 32));
//                } else {
//                    // Letter is Cyrillic
//                    resultWord.append((char) (c - 32));
//                }
//            } else {
//                // Letter is already lowerrcase.
//                resultWord.append(c);
//            }
//        }
//        return resultWord.toString();
//    }
//
//    public String ToUpperCase(String input){
//        StringBuffer resultWord = new StringBuffer();
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//
//            if (Character.isLowerCase(c)) {
//                // Change particular lowercase char with its uppercase analog.
//                if ((int) c < (int) 'Z') {
//                    // Letter is Latin.
//                    resultWord.append((char) (c + 32));
//                } else {
//                    // Letter is Cyrillic
//                    resultWord.append((char) (c + 32));
//                }
//            } else {
//                // Letter is already uppercase.
//                resultWord.append(c);
//            }
//        }
//        return resultWord.toString();
//    }

//    public static boolean isLowerCase(char inputChar) {
//        return ((inputChar >= 'a') && (inputChar <= 'z'))
//                || ((inputChar >= 'à') && (inputChar <= 'ÿ'));
//    }
//
//    public static boolean isUpperCase(char inputChar) {
//        return ((inputChar >= 'A') && (inputChar <= 'A'))
//                || ((inputChar >= 'À') && (inputChar <= 'ß'));
//    }

    String getInUppercase(){
        //return ToUpperCase(_word.getWordText());
        String result = new String(_word.getWordText());

        result.toUpperCase();
        return result;
    }

    String getInLowercase(){
        //return ToLowerCase(_word.getWordText());
        String result = new String(_word.getWordText());

        result.toLowerCase();
        return result;
    }

    public int getLCharactersNumber(){
        return _word.getWordText().length();
    }

    public int getGuessedStatus(){
        return _guessedStatus;
    }

    public boolean getIsGuessed(){
        return _guessedStatus == GUESSED_STATUS;
    }

    public boolean getIsUnguessed(){
        return _guessedStatus == UNGUESSED_STATUS;
    }

    public boolean getIsNeutral(){
        return _guessedStatus == NEUTRAL_STATUS;
    }

    public void markGuessed(){
        _guessedStatus = GUESSED_STATUS;
    }

    public void markNeutral(){
        _guessedStatus = NEUTRAL_STATUS;
    }

    public void markUnguessed() {
        _guessedStatus = UNGUESSED_STATUS;
    }
}