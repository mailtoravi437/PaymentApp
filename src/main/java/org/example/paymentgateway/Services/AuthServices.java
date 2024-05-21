package org.example.paymentgateway.Services;

import org.example.paymentgateway.Models.User;
import org.example.paymentgateway.Models.UserLoginDO;
import org.example.paymentgateway.Models.UserResponse;
import org.example.paymentgateway.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServices {
    private UserRepository userRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public AuthServices(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    public void register(UserLoginDO userLoginDO) {
        // Register user
        User user = new User();
        user.setName(userLoginDO.getUsername());
        user.setEmail(userLoginDO.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userLoginDO.getPassword()));
        userRepository.save(user);
    }

    public boolean login(UserLoginDO userLoginDO) {
        // Login user
        User user = userRepository.findByEmail(userLoginDO.getEmail());
        return bCryptPasswordEncoder.matches(userLoginDO.getPassword(), user.getPassword());
    }

    public UserResponse getUser(String username) {
        // Get user
        User user = userRepository.findByUsername(username);
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(user.getName());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
}
