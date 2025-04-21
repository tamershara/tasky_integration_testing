package com.qacart.tasky.Fixtures;

import com.qacart.tasky.model.CreditCardInfo;

public final class CreditCardFixture {
    private CreditCardFixture() {}

    public static CreditCardInfo defaultCardInfo() {
        return  CreditCardInfo
                .builder()
                .setCardNumber("4111111111111111")
                .setExpiryMonth("03")
                .setExpiryYear("2030")
                .setCvv("123")
                .build();
    }

}
