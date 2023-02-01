package com.pluralsight;

import com.pluralsight.iterator.BookCollectionFactory;
import com.pluralsight.iterator.IBookCollection;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class IteratorTests {
    @Test
    public void testIterateCollectionWithIterator() {
        IBookCollection collection = BookCollectionFactory.getBookCollection();

        collection.addBook("El Quijote");
        collection.addBook("Lazarillo de Tormes");
        collection.addBook("Romeo & Juliet");

        Iterator<String> iterator = collection.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("El Quijote", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Lazarillo de Tormes", iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals("Romeo & Juliet", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testShouldIterateWithForeachApproach() {
        IBookCollection collection = BookCollectionFactory.getBookCollection();

        collection.addBook("Tomillo y orégano");
        collection.addBook("El bosón de Higgs no te va a hacer la cama");
        collection.addBook("Teoría del Todo");
        collection.addBook("Para qué sirve un cuñao");

        int index = 0;

        for (String book : collection) {
            switch (index) {
                case 0:
                    assertEquals("Tomillo y orégano", book);
                    break;
                case 1:
                    assertEquals("El bosón de Higgs no te va a hacer la cama", book);
                    break;
                case 2:
                    assertEquals("Teoría del Todo", book);
                    break;
                case 3:
                    assertEquals("Para qué sirve un cuñao", book);
                    break;
                default:
                    throw new UnsupportedOperationException();
            }

            index++;
        }
    }
}
