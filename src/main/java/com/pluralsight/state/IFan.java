package com.pluralsight.state;

public interface IFan {
    void pullChain();
    void setState(StateType type);
    IState getState();
}
