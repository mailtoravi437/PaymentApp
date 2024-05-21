package org.example.paymentgateway.Models;

public interface Command {
    void execute();
    void undo();
}
