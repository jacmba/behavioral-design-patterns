package com.pluralsight.visitor;

public interface PcPart {
    void accept(PcPartVisitor visitor);
}
