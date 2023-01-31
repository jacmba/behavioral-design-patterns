package com.pluralsight.chain;

import com.pluralsight.chain.handler.*;
import com.pluralsight.chain.request.Request;
import com.pluralsight.chain.request.RequestType;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResponsibilityChainTests {
    private IHandler director;
    private IHandler vp;
    private IHandler ceo;

    @Before
    public void setup() {
        director = Handler.HandlerFactory.getHandler("John", HandlerType.DIRECTOR);
        vp = Handler.HandlerFactory.getHandler("Jack", HandlerType.VP);
        ceo = Handler.HandlerFactory.getHandler("Chuck", HandlerType.CEO);

        director.setSuccessor(vp);
        vp.setSuccessor(ceo);
    }

    @Test
    public void testCreateRequestByFactory() {
        Request request1 = Request.RequestFactory.getRequest(RequestType.PURCHASE, 100);
        Request request2 = Request.RequestFactory.getRequest(RequestType.CONFERENCE, 10);
        Request request3 = Request.RequestFactory.getRequest(RequestType.CONFERENCE);

        assertEquals(RequestType.PURCHASE, request1.getType());
        assertEquals(100, request1.getAmount());

        assertEquals(RequestType.CONFERENCE, request2.getType());
        assertEquals(10, request2.getAmount());

        assertEquals(RequestType.CONFERENCE, request3.getType());
        assertEquals(0, request3.getAmount());
    }

    @Test
    public void testDirectorApproval(){
        Request request = Request.RequestFactory.getRequest(RequestType.CONFERENCE);

        director.handle(request);

        IHandler approvedBy = request.getApproval();

        assertNotNull(approvedBy);
        assertTrue(approvedBy instanceof Director);
        assertEquals("John", approvedBy.getName());
    }

    @Test
    public void testVPApproval() {
        Request request = Request.RequestFactory.getRequest(RequestType.PURCHASE, 100);

        director.handle(request);

        IHandler approvedBy = request.getApproval();

        assertNotNull(approvedBy);
        assertTrue(approvedBy instanceof VP);
        assertEquals("Jack", approvedBy.getName());
    }

    @Test
    public void testCEOApproval() {
        Request request = Request.RequestFactory.getRequest(RequestType.PURCHASE, 5000);

        director.handle(request);

        IHandler approvedBy = request.getApproval();

        assertNotNull(approvedBy);
        assertTrue(approvedBy instanceof CEO);
        assertEquals("Chuck", approvedBy.getName());
    }
}
