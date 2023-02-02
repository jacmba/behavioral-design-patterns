package com.pluralsight.strategy.validation;

import com.pluralsight.strategy.context.ICreditCard;

public interface IValidationStrategy {
    boolean isValid(ICreditCard card);
}
