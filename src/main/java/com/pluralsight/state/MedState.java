package com.pluralsight.state;

public class MedState extends State {
    protected MedState(IFan fan) {
        super(fan);
    }

    @Override
    public void handle() {
        fan.setState(StateType.HIGH);
    }

    @Override
    public StateType getType() {
        return StateType.MED;
    }
}
