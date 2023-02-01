package com.pluralsight.mediator;

import com.pluralsight.command.ILight;

public interface IMediator {
    void registerLight(ILight light);
    void turnOnAllLights();
    void turnOffAllLights();
}
