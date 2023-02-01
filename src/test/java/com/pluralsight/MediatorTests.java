package com.pluralsight;

import com.pluralsight.command.ILight;
import com.pluralsight.command.Light;
import com.pluralsight.command.LightStatus;
import com.pluralsight.mediator.IMediator;
import com.pluralsight.mediator.Mediator;
import com.pluralsight.mediator.MediatorCommand;
import com.pluralsight.mediator.MediatorCommandType;
import org.junit.Test;
import static org.junit.Assert.*;

public class MediatorTests {
    @Test
    public void testTurnAllLightsWithMediator() {
        ILight bedroomLight = Light.LightFactory.getLight();
        ILight kitchenLight = Light.LightFactory.getLight();

        IMediator mediator = Mediator.MediatorFactory.getMediator();
        mediator.registerLight(bedroomLight);
        mediator.registerLight(kitchenLight);

        assertEquals(LightStatus.OFF, bedroomLight.getStatus());
        assertEquals(LightStatus.OFF, kitchenLight.getStatus());

        MediatorCommand turnOnAllCommand = MediatorCommand.MediatorCommandFactory.getCommand(mediator, MediatorCommandType.TURN_ON_ALL);
        MediatorCommand turnOffAllCommand = MediatorCommand.MediatorCommandFactory.getCommand(mediator, MediatorCommandType.TURN_OFF_ALL);

        turnOnAllCommand.execute();
        assertEquals(LightStatus.ON, bedroomLight.getStatus());
        assertEquals(LightStatus.ON, kitchenLight.getStatus());

        turnOffAllCommand.execute();
        assertEquals(LightStatus.OFF, bedroomLight.getStatus());
        assertEquals(LightStatus.OFF, kitchenLight.getStatus());
    }
}
