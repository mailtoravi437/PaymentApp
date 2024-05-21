package org.example.paymentgateway.Models;


import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class InstrumentDO {
    private int id;
    private int userId;
    private String cardNumber;
    private String cardHolderName;
    private InstrumentType instrumentType;
    private String IFSCCode;
    private String accountNumber;
    private String CVV;
}
