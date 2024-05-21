package org.example.paymentgateway.Repository;

import org.example.paymentgateway.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    @Query("SELECT t FROM Transaction t WHERE t.senderId = ?1")
    List<Transaction> findBySenderId(Long userId);

    @Query("SELECT t FROM Transaction t WHERE t.receiverId = ?1")
    List<Transaction> findByReceiverId(Long userId);
}
