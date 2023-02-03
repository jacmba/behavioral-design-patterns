package com.pluralsight.visitor;

import java.util.ArrayList;
import java.util.List;

public class PcOrderPart implements PcPart {
    public static class PcOrderPartBuilder {
        private final PcOrderPart order = new PcOrderPart();

        public PcOrderPartBuilder part(PcPart p) {
            order.parts.add(p);
            return this;
        }

        public PcOrderPart build() {
            return order;
        }
    }
    private final List<PcPart> parts;

    private PcOrderPart() {
        parts = new ArrayList<>();
    }

    @Override
    public void accept(PcPartVisitor visitor) {
        for (PcPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }

    public int getNumParts() {
        return parts.size();
    }
}
