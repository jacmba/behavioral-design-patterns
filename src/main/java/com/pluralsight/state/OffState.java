package com.pluralsight.state;

public class OffState extends State {
    protected OffState(IFan fan) {
        super(fan);
    }

    @Override
    public void handle() {
        fan.setState(StateType.LOW);
    }

    @Override
    public StateType getType() {
        return StateType.OFF;
    }
}
