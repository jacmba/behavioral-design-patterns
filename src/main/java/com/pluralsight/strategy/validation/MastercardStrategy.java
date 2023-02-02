package com.pluralsight.strategy.validation;

import com.pluralsight.strategy.context.ICreditCard;

public class MastercardStrategy extends ValidationStrategy {
    protected MastercardStrategy() {}

    @Override
    public boolean isValid(ICreditCard card) {
        return card.getNumber().startsWith("51") && validateDateCvv(card)
                && fantasyChecksum(card.getNumber()) && card.getNumber().length() == 15;
    }
}
