package com.pluralsight.mediator;

import com.pluralsight.command.ILight;

import java.util.ArrayList;
import java.util.List;

public class Mediator implements IMediator {
    private List<ILight> lights;

    private Mediator() {
        lights = new ArrayList<>();
    }

    public static class MediatorFactory {
        public static IMediator getMediator() {
            return new Mediator();
        }
    }

    @Override
    public void registerLight(ILight light) {
        lights.add(light);
    }

    @Override
    public void turnOnAllLights() {
        for (ILight light : lights) {
            light.on();
        }
    }

    @Override
    public void turnOffAllLights() {
        for (ILight light : lights) {
            light.off();
        }
    }
}
