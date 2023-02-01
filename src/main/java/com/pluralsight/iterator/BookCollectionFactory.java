package com.pluralsight.iterator;

public class BookCollectionFactory {
    public static IBookCollection getBookCollection() {
        return new BookCollection();
    }
}
