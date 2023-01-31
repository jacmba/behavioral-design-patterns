package com.pluralsight.command;

public interface ILight {
    void on();
    void off();
    LightStatus getStatus();
}
