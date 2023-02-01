package com.pluralsight.observer;

public abstract class Observer {
    protected Subject subject;
    protected String state;
    abstract void update();

    public String getState() {
        return state;
    }
}
