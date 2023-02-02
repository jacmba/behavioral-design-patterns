package com.pluralsight.state;

public interface IState {
    void handle();
    StateType getType();
}
