package com.pluralsight.state;

public abstract class State implements IState {
    public static class StateFactory {
        public static IState getState(StateType type, IFan fan) {
            switch (type) {
                case OFF:
                    return new OffState(fan);
                case LOW:
                    return new LowState(fan);
                case MED:
                    return new MedState(fan);
                case HIGH:
                    return new HighState(fan);
            }

            throw new UnsupportedOperationException();
        }
    }

    protected final IFan fan;
    protected State(IFan fan) {
        this.fan = fan;
    }
}
