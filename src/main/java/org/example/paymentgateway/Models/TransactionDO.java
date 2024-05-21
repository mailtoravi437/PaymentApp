package org.example.paymentgateway.Models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TransactionDO {
    String transactionId;
    double amount;
    String senderId;
    String receiverId;
    String senderInstrumentId;
    String receiverInstrumentId;
    TransactionStatus transactionStatus;
}
