package com.pluralsight.strategy.context;

public interface ICreditCard {
    String getNumber();
    String getCvv();
    String getDate();
    boolean isValid();
}
