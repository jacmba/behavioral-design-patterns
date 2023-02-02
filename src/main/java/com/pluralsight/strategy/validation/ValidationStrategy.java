package com.pluralsight.strategy.validation;

import com.pluralsight.strategy.context.CardType;
import com.pluralsight.strategy.context.ICreditCard;

public abstract class ValidationStrategy implements IValidationStrategy {
    public static class ValidationStrategyFactory {
        public static IValidationStrategy getStrategy(CardType type) {
            switch (type) {
                case AMEX:
                    return new AmexStrategy();
                case VISA:
                    return new VisaStrategy();
                case MASTERCARD:
                    return new MastercardStrategy();
            }

            throw new UnsupportedOperationException();
        }
    }

    protected boolean fantasyChecksum(String number) {
        int sum = 0;

        for (String n : number.split("")) {
            sum += Integer.parseInt(n);
        }

        return sum == 10;
    }

    protected boolean validateDateCvv(ICreditCard card) {
        return card.getCvv().length() == 3 && card.getDate().length() == 5;
    }
}
