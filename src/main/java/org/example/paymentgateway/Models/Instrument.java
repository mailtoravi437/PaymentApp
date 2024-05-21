package org.example.paymentgateway.Models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public abstract class Instrument {
    String instrumentId;
    InstrumentType instrumentType;
    int userId;
}
