package com.pluralsight.strategy.validation;

import com.pluralsight.strategy.context.ICreditCard;

public class AmexStrategy extends ValidationStrategy {
    protected AmexStrategy() {}

    @Override
    public boolean isValid(ICreditCard card) {
        String number = card.getNumber();

        return number.length() == 10 && validateDateCvv(card) &&
                number.startsWith("12") && fantasyChecksum(number);
    }
}
