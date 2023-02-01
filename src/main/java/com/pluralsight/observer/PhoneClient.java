package com.pluralsight.observer;

public class PhoneClient extends Observer {
    public PhoneClient(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(String message) {
        subject.setState(message + " - Sent from phone");
    }

    @Override
    void update() {
        state = "Phone stream: " + subject.getState();
    }
}
