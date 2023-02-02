package com.pluralsight.strategy.context;

import com.pluralsight.strategy.validation.IValidationStrategy;

public interface ICreditCardBuilder {
    ICreditCardBuilder number(String num);
    ICreditCardBuilder cvv(String cvv);
    ICreditCardBuilder date(String date);
    ICreditCardBuilder strategy(IValidationStrategy strategy);

    ICreditCard build();
}
