package com.pluralsight.chain.handler;

public abstract class Handler implements IHandler {
    protected IHandler successor;
    private final String name;

    protected Handler(String name) {
        this.name = name;
    }
    public static class HandlerFactory {
        public static IHandler getHandler(String name, HandlerType type) {
            switch (type) {
                case DIRECTOR:
                    return new Director(name);
                case VP:
                    return new VP(name);
                case CEO:
                    return new CEO(name);
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public void setSuccessor(IHandler successor) {
        this.successor = successor;
    }

    @Override
    public String getName() {
        return name;
    }
}
