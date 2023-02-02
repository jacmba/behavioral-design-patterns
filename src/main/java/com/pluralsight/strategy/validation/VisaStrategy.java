package com.pluralsight.strategy.validation;

import com.pluralsight.strategy.context.ICreditCard;

public class VisaStrategy extends ValidationStrategy {
    protected VisaStrategy() {}

    @Override
    public boolean isValid(ICreditCard card) {
        return card.getNumber().length() == 12 && validateDateCvv(card) &&
                card.getNumber().startsWith("34") && fantasyChecksum(card.getNumber());
    }
}
