package com.pluralsight.chain.handler;

import com.pluralsight.chain.request.Request;

public interface IHandler {
    void handle(Request request);
    void setSuccessor(IHandler successor);
    String getName();
}
