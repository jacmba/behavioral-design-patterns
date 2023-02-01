package com.pluralsight.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class BookCollection implements IBookCollection {
    private String [] books;
    private int index;

    private class BookIterator implements Iterator<String> {
        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public String next() {
            return books[index++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer<? super String> action) {
            throw new UnsupportedOperationException();
        }
    }

    protected BookCollection() {
        books = new String[]{};
        index = 0;
    }
    @Override
    public void addBook(String title) {
        String [] newCollection = new String[books.length + 1];
        System.arraycopy(books, 0, newCollection, 0, books.length);
        newCollection[books.length] = title;
        books = newCollection;
    }

    @Override
    public Iterator<String> iterator() {
        return new BookIterator();
    }

    @Override
    public void forEach(Consumer<? super String> action) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Spliterator<String> spliterator() {
       throw new UnsupportedOperationException();
    }
}
