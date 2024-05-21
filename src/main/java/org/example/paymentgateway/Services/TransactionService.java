package org.example.paymentgateway.Services;

import lombok.extern.slf4j.Slf4j;
import org.example.paymentgateway.Models.Transaction;
import org.example.paymentgateway.Models.TransactionDO;
import org.example.paymentgateway.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {

    Logger logger = Logger.getLogger(TransactionService.class.getName());
    @Autowired
    TransactionRepository transactionRepository;

    public void makePayment(TransactionDO transactionDO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionDO.getAmount());
        transaction.setSenderId(transactionDO.getSenderId());
        transaction.setReceiverId(transactionDO.getReceiverId());
        logger.info("Transaction made successfully");
        transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory(Long userId) {
        List<Transaction> transactions = transactionRepository.findBySenderId(userId);
        logger.info("Transaction history fetched successfully");
        return transactions;
    }
}
