package com.pluralsight.visitor;

public class GpuPart implements PcPart {
    @Override
    public void accept(PcPartVisitor visitor) {
        visitor.visit(this);
    }
}
