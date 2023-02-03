package com.pluralsight.visitor;

public interface PcPartVisitor {
    int getTotal();
    void visit(BoardPart part);
    void visit(CpuPart part);
    void visit(GpuPart part);
    void visit(PcOrderPart part);
}
