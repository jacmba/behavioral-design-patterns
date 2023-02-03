package com.pluralsight;

import com.pluralsight.visitor.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class VisitorTests {
    @Test
    public void testVisitorPattern() {
        PcPart order = new PcOrderPart.PcOrderPartBuilder()
                .part(new BoardPart()) // Board costs 150
                .part(new CpuPart()) // CPU costs 500
                .part(new GpuPart()) // GPU costs 1000
                .build(); // Total order cost is 1650

        PcPartVisitor visitor = new PcPartConcreteVisitor();

        order.accept(visitor);

        assertEquals(1650, visitor.getTotal());
    }

    @Test
    public void testVisitorOrderWithMoreThan3PartsShouldHaveDiscount() {
        PcPart order = new PcOrderPart.PcOrderPartBuilder()
                .part(new BoardPart())
                .part(new CpuPart())
                .part(new CpuPart()) // Second CPU
                .part(new GpuPart())
                .build(); // Total gross is 2150, 1935 with 10% discount

        PcPartVisitor visitor = new PcPartConcreteVisitor();

        order.accept(visitor);

        assertEquals(1935, visitor.getTotal());
    }
}
