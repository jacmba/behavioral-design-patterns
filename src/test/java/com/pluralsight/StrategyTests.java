package com.pluralsight;

import com.pluralsight.strategy.context.CardType;
import com.pluralsight.strategy.context.CreditCardBuilder;
import com.pluralsight.strategy.context.ICreditCard;
import com.pluralsight.strategy.context.ICreditCardBuilder;
import com.pluralsight.strategy.validation.IValidationStrategy;
import com.pluralsight.strategy.validation.ValidationStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class StrategyTests {
    @Test
    public void testAmexStrategy() {
        IValidationStrategy strategy = ValidationStrategy.ValidationStrategyFactory.getStrategy(CardType.AMEX);

        ICreditCardBuilder builder = new CreditCardBuilder();

        ICreditCard amexCard = builder
                .strategy(strategy)
                .number("1200000007")
                .date("01/25")
                .cvv("123")
                .build();

        assertEquals("1200000007", amexCard.getNumber());
        assertEquals("01/25", amexCard.getDate());
        assertEquals("123", amexCard.getCvv());
        assertTrue(amexCard.isValid());

        ICreditCard invalidAmexCard = builder
                .number("1200000008")
                .build();

        assertEquals("1200000008", invalidAmexCard.getNumber());
        assertEquals("01/25", invalidAmexCard.getDate());
        assertEquals("123", invalidAmexCard.getCvv());
        assertFalse(amexCard.isValid());
    }

    @Test
    public void testVisaStrategy() {
        IValidationStrategy strategy = ValidationStrategy.ValidationStrategyFactory.getStrategy(CardType.VISA);

        ICreditCardBuilder builder = new CreditCardBuilder();

        ICreditCard visaCard = builder
                .strategy(strategy)
                .number("340000000003")
                .date("01/27")
                .cvv("456")
                .build();

        assertEquals("340000000003", visaCard.getNumber());
        assertEquals("01/27", visaCard.getDate());
        assertEquals("456", visaCard.getCvv());
        assertTrue(visaCard.isValid());

        ICreditCard invalidVisaCard = builder
                .number("310000000006")
                .build();

        assertEquals("310000000006", invalidVisaCard.getNumber());
        assertEquals("01/27", invalidVisaCard.getDate());
        assertEquals("456", invalidVisaCard.getCvv());
        assertFalse(invalidVisaCard.isValid());
    }

    @Test
    public void testMastercardStrategy() {
        IValidationStrategy strategy = ValidationStrategy.ValidationStrategyFactory.getStrategy(CardType.MASTERCARD);

        ICreditCardBuilder builder = new CreditCardBuilder();

        ICreditCard mastercard = builder
                .strategy(strategy)
                .number("510000000000004")
                .date("01/33")
                .cvv("789")
                .build();

        assertEquals("510000000000004", mastercard.getNumber());
        assertEquals("01/33", mastercard.getDate());
        assertEquals("789", mastercard.getCvv());
        assertTrue(mastercard.isValid());

        ICreditCard invalidMastercard = builder
                .number("51004")
                .build();

        assertEquals("51004", invalidMastercard.getNumber());
        assertEquals("01/33", invalidMastercard.getDate());
        assertEquals("789", invalidMastercard.getCvv());
        assertFalse(invalidMastercard.isValid());
    }
}
