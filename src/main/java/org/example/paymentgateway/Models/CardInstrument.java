package org.example.paymentgateway.Models;

import lombok.Data;

@Data
public class CardInstrument extends Instrument{
    String cardNumber;
    String CVV;
}
