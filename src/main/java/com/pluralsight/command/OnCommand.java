package com.pluralsight.command;

public class OnCommand implements ICommand {
    private final ILight light;

    private OnCommand(ILight light) {
        this.light = light;
    }

    public static class OnCommandFactory {
        public static OnCommand getOnCommand(ILight light) {
            return new OnCommand(light);
        }
    }

    @Override
    public void execute() {
        light.on();
    }
}
