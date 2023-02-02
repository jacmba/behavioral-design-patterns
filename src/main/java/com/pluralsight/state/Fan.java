package com.pluralsight.state;

import java.util.HashMap;
import java.util.Map;

public class Fan implements IFan {
    private final Map<StateType, IState> stateMap;
    private IState state;
    private Fan() {
        stateMap = new HashMap<>();

        state = State.StateFactory.getState(StateType.OFF, this);
        stateMap.put(StateType.OFF, state);
        stateMap.put(StateType.LOW, State.StateFactory.getState(StateType.LOW, this));
        stateMap.put(StateType.MED, State.StateFactory.getState(StateType.MED, this));
        stateMap.put(StateType.HIGH, State.StateFactory.getState(StateType.HIGH, this));
    }

    public static class FanFactory {
        public static IFan getFan() {
            return new Fan();
        }
    }

    @Override
    public void pullChain() {
        state.handle();
    }

    @Override
    public void setState(StateType type) {
        state = stateMap.get(type);
    }

    @Override
    public IState getState() {
        return state;
    }
}
