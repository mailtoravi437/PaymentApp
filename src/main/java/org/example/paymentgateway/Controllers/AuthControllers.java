package org.example.paymentgateway.Controllers;

import org.example.paymentgateway.Models.User;
import org.example.paymentgateway.Models.UserLoginDO;
import org.example.paymentgateway.Models.UserResponse;
import org.example.paymentgateway.Services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControllers {
    @Autowired
    private AuthServices authServices;
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserLoginDO userLoginDO){
        authServices.register(userLoginDO);
        return new ResponseEntity<>("User registered", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDO userLoginDO){
        return new ResponseEntity<>("User logged in", HttpStatus.OK);
    }

    @GetMapping("/getUser/{username}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String username){
        UserResponse userResponse = authServices.getUser(username);
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }
}
