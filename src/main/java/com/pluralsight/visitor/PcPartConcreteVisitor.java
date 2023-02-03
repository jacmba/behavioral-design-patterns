package com.pluralsight.visitor;

public class PcPartConcreteVisitor implements PcPartVisitor {
    private int total;

    public PcPartConcreteVisitor() {
        total = 0;
    }

    @Override
    public int getTotal() {
        return total;
    }

    @Override
    public void visit(BoardPart part) {
        total += 150;
    }

    @Override
    public void visit(CpuPart part) {
        total += 500;
    }

    @Override
    public void visit(GpuPart part) {
        total += 1000;
    }

    @Override
    public void visit(PcOrderPart part) {
        if (part.getNumParts() > 3) {
            int discount = total / 10;
            total -= discount;
        }
    }
}
