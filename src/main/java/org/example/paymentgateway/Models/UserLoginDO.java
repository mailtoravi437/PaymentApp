package org.example.paymentgateway.Models;

import lombok.Data;

@Data
public class UserLoginDO {
    private String username;
    private String email;
    private String password;
}
