package com.pluralsight.visitor;

public class CpuPart implements PcPart {
    @Override
    public void accept(PcPartVisitor visitor) {
        visitor.visit(this);
    }
}
