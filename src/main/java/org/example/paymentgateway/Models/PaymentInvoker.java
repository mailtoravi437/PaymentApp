package org.example.paymentgateway.Models;

import lombok.Data;

@Data
public class PaymentInvoker {
    private Command command;
    public void executeCommand(){
        command.execute();
    }
}
