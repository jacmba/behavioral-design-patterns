package com.pluralsight.chain.handler;

import com.pluralsight.chain.request.Request;
import com.pluralsight.chain.request.RequestType;

public class Director extends Handler {
    protected Director(String name) {
        super(name);
    }

    @Override
    public void handle(Request request) {
        if (request.getType().equals(RequestType.CONFERENCE)) {
            request.approve(this);
        } else {
            successor.handle(request);
        }
    }
}
