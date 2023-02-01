package com.pluralsight.mediator;

import com.pluralsight.command.ICommand;

public abstract class MediatorCommand implements ICommand {
    protected IMediator mediator;

    protected MediatorCommand(IMediator mediator) {
        this.mediator = mediator;
    }

    public static class MediatorCommandFactory {
        public static MediatorCommand getCommand(IMediator mediator, MediatorCommandType type) {
            switch (type) {
                case TURN_ON_ALL:
                    return new AllLightsOnCommand(mediator);
                case TURN_OFF_ALL:
                    return new AllLightsOffCommand(mediator);
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }
}
