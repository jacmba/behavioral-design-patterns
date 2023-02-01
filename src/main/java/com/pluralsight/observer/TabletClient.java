package com.pluralsight.observer;

public class TabletClient extends Observer {
    public TabletClient(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    public void addMessage(String message) {
        subject.setState(message + " - Sent from tablet");
    }

    @Override
    void update() {
        state = "Tablet stream: " + subject.getState();
    }
}
