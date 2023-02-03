package com.pluralsight.visitor;

public class BoardPart implements PcPart {
    @Override
    public void accept(PcPartVisitor visitor) {
        visitor.visit(this);
    }
}
