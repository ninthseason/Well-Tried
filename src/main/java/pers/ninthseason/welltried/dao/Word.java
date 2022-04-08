package pers.ninthseason.welltried.dao;

import java.io.Serializable;

public class Word implements Serializable {
    private int id;
    private String word;
    private String transition;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTransition() {
        return transition;
    }

    public void setTransition(String transition) {
        this.transition = transition;
    }

    @Override
    public String toString() {
        return "\""+id+"\":{\"word\":\""+word+"\",\"transition\":\""+transition+"\"}";
    }
}
