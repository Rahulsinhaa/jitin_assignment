package com.assignment.login_signup.services;

import com.assignment.login_signup.model.User;
import com.assignment.login_signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginSerivce {
    @Autowired
    private  UserRepository userRepository;



    public User login(String username, String password) {
        // Find the user by username
        User user = userRepository.findByUsername(username);

        // Check if the user exists
        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Check if the provided password matches the stored password
        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password.");
        }

        // Return the user if login is successful
        return user;
    }
}
