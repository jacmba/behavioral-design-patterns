package com.pluralsight.iterator;

public interface IBookCollection extends Iterable<String> {
    void addBook(String title);
}
