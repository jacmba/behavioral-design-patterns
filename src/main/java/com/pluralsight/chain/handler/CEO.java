package com.pluralsight.chain.handler;

import com.pluralsight.chain.request.Request;

public class CEO extends Handler {
    protected CEO (String name) {
        super(name);
    }
    @Override
    public void handle(Request request) {
        request.approve(this);
    }
}
