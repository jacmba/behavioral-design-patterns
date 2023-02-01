package com.pluralsight.mediator;

public class AllLightsOffCommand extends MediatorCommand {
    protected AllLightsOffCommand(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void execute() {
        mediator.turnOffAllLights();
    }
}
