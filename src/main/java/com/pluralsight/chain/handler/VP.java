package com.pluralsight.chain.handler;

import com.pluralsight.chain.request.Request;
import com.pluralsight.chain.request.RequestType;

public class VP extends Handler {
    protected VP(String name) {
        super(name);
    }

    @Override
    public void handle(Request request) {
        if (request.getType().equals(RequestType.CONFERENCE) || request.getAmount() < 1500) {
            request.approve(this);
        } else {
            successor.handle(request);
        }
    }
}
