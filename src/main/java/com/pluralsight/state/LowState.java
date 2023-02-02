package com.pluralsight.state;

public class LowState extends State {
    protected LowState(IFan fan) {
        super(fan);
    }

    @Override
    public void handle() {
        fan.setState(StateType.MED);
    }

    @Override
    public StateType getType() {
        return StateType.LOW;
    }
}
