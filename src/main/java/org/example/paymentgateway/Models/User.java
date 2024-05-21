package org.example.paymentgateway.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    private String userId;
    private String username;
    private String name;
    private String email;
    private String password;

    @PrePersist
    public void generateUserId() {
        if (userId == null) {
            userId = UUID.randomUUID().toString();
        }
    }

    // getters and setters
}