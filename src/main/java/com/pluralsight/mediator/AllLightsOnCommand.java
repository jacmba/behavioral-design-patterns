package com.pluralsight.mediator;

public class AllLightsOnCommand extends MediatorCommand {
    protected AllLightsOnCommand (IMediator mediator) {
        super(mediator);
    }
    @Override
    public void execute() {
        mediator.turnOnAllLights();
    }
}
