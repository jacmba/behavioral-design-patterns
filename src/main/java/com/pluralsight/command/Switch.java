package com.pluralsight.command;

public class Switch implements ISwitch {
    private Switch() {}

    public static class SwitchFactory {
        public static ISwitch getSwitch() {
            return new Switch();
        }
    }

    @Override
    public void storeAndExecute(ICommand command) {
        command.execute();
    }
}
