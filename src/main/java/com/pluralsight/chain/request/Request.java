package com.pluralsight.chain.request;

import com.pluralsight.chain.handler.Handler;

public class Request {

    private final RequestType type;
    private final int amount;
    private Handler approvedBy;

    public static class  RequestFactory {
        public static Request getRequest(RequestType type, int amount) {
            return new Request(type, amount);
        }

        public static Request getRequest(RequestType type) {
            return new Request(type, 0);
        }
    }

    private Request(RequestType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public RequestType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void approve(Handler handler) {
        approvedBy = handler;
    }

    public Handler getApproval() {
        return approvedBy;
    }
}
