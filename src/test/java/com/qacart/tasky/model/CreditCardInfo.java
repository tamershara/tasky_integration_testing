package com.qacart.tasky.model;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(setterPrefix = "set")
public class CreditCardInfo {
    private String cardNumber;
    private String expiryMonth;
    private String expiryYear;
    private String cvv;
}
