package org.example.paymentgateway.Models;

import org.example.paymentgateway.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MakePaymentCommand implements Command{
    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionDO transactionDO;
    @Override
    public void execute() {
        transactionService.makePayment(transactionDO);
    }

    @Override
    public void undo() {

    }
}
