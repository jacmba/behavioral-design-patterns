package com.pluralsight.chain;

import com.pluralsight.command.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class CommandTests {
    @Test
    public void testLightCreation() {
        ILight light = Light.LightFactory.getLight();
        assertNotNull(light);
        assertEquals(LightStatus.OFF, light.getStatus());

        light.on();
        assertEquals(LightStatus.ON, light.getStatus());

        light.off();
        assertEquals(LightStatus.OFF, light.getStatus());
    }

    @Test
    public void testLightOnCommand() {
        ILight light = Light.LightFactory.getLight();
        ISwitch lightSwitch = Switch.SwitchFactory.getSwitch();
        ICommand cmd = OnCommand.OnCommandFactory.getOnCommand(light);

        lightSwitch.storeAndExecute(cmd);

        assertEquals(LightStatus.ON, light.getStatus());
    }
}
