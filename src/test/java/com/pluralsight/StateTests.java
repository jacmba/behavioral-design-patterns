package com.pluralsight;

import com.pluralsight.state.Fan;
import com.pluralsight.state.IFan;
import com.pluralsight.state.StateType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StateTests {
    @Test
    public void testStates () {
        IFan fan = Fan.FanFactory.getFan();

        assertNotNull(fan);
        assertEquals(StateType.OFF, fan.getState().getType());

        fan.pullChain();
        assertEquals(StateType.LOW, fan.getState().getType());

        fan.pullChain();
        assertEquals(StateType.MED, fan.getState().getType());

        fan.pullChain();
        assertEquals(StateType.HIGH, fan.getState().getType());

        fan.pullChain();
        assertEquals(StateType.OFF, fan.getState().getType());
    }
}
