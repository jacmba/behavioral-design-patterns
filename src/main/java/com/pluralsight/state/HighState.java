package com.pluralsight.state;

public class HighState extends State {
    protected HighState(IFan fan) {
        super(fan);
    }

    @Override
    public void handle() {
        fan.setState(StateType.OFF);
    }

    @Override
    public StateType getType() {
        return StateType.HIGH;
    }
}
