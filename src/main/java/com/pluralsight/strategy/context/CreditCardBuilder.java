package com.pluralsight.strategy.context;

import com.pluralsight.strategy.validation.IValidationStrategy;

public class CreditCardBuilder implements ICreditCardBuilder {
    private final CreditCard card;

    public CreditCardBuilder() {
        card = new CreditCard();
    }

    @Override
    public ICreditCardBuilder number(String num) {
        card.number = num;
        return this;
    }

    @Override
    public ICreditCardBuilder cvv(String cvv) {
        card.cvv = cvv;
        return this;
    }

    @Override
    public ICreditCardBuilder date(String date) {
        card.date = date;
        return this;
    }

    @Override
    public ICreditCardBuilder strategy(IValidationStrategy strategy) {
        card.strategy = strategy;
        return this;
    }

    @Override
    public ICreditCard build() {
        return card;
    }
}
