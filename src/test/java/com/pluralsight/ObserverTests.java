package com.pluralsight;

import com.pluralsight.observer.MessageStream;
import com.pluralsight.observer.PhoneClient;
import com.pluralsight.observer.Subject;
import com.pluralsight.observer.TabletClient;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObserverTests {
    @Test
    public void testMessageStream() {
        Subject stream = new MessageStream();
        PhoneClient phoneClient = new PhoneClient(stream);
        TabletClient tabletClient = new TabletClient(stream);

        phoneClient.addMessage("Hello observable world");

        assertEquals("Phone stream: Hello observable world - Sent from phone", phoneClient.getState());
        assertEquals("Tablet stream: Hello observable world - Sent from phone", tabletClient.getState());

        tabletClient.addMessage("This is just another test message");

        assertEquals("Phone stream: This is just another test message - Sent from tablet", phoneClient.getState());
        assertEquals("Tablet stream: This is just another test message - Sent from tablet", tabletClient.getState());

        stream.detach(phoneClient);
        stream.detach(tabletClient);
    }
}
