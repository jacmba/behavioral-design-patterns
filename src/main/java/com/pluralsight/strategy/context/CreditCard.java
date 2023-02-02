package com.pluralsight.strategy.context;

import com.pluralsight.strategy.validation.IValidationStrategy;

public class CreditCard implements ICreditCard {
    protected String number;
    protected String cvv;
    protected String date;
    protected IValidationStrategy strategy;

    protected CreditCard() {}

    public String getNumber() {
        return number;
    }

    public String getCvv() {
        return cvv;
    }

    public String getDate() {
        return date;
    }

    @Override
    public boolean isValid() {
        return strategy.isValid(this);
    }
}
