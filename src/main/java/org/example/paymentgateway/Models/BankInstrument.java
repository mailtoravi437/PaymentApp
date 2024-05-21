package org.example.paymentgateway.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankInstrument extends Instrument
{
    private String accountNumber;
    private String IFSCCode;
}
