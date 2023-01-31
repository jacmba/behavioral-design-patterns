package com.pluralsight.command;

public class Light implements ILight {
    private LightStatus status;

    private Light() {
        status = LightStatus.OFF;
    }

    public static class LightFactory {
        public static ILight getLight() {
            return new Light();
        }
    }

    @Override
    public void on() {
        status = LightStatus.ON;
    }

    @Override
    public void off() {
        status = LightStatus.OFF;
    }

    @Override
    public LightStatus getStatus() {
        return status;
    }
}
