package org.example.paymentgateway.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Transaction {
    @Id
    String transactionId;
    double amount;
    String senderId;
    String receiverId;
    String senderInstrumentId;
    String receiverInstrumentId;
    TransactionStatus transactionStatus;
}
