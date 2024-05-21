package org.example.paymentgateway.Controllers;

import org.example.paymentgateway.Models.*;
import org.example.paymentgateway.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody TransactionDO transactionDO){
        Command command = new MakePaymentCommand();
        PaymentInvoker paymentInvoker = new PaymentInvoker();
        paymentInvoker.setCommand(command);
        paymentInvoker.executeCommand();
        return ResponseEntity.ok("Payment Successful");
    }

    @GetMapping("/getTransactionHistory/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long userId){
        List<Transaction> transactions = transactionService.getTransactionHistory(userId);
        return new ResponseEntity<>(transactions, (HttpStatusCode) (transactions.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok()));
    }
}
