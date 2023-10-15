package com.assignment.login_signup.services;

import com.assignment.login_signup.model.User;
import com.assignment.login_signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupService {
    @Autowired
    private  UserRepository userRepository;




    public User registerUser(User user) {
        // Check if the username or email is already in use
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username is already in use.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email is already in use.");
        }

        // Save the user to the database
        return userRepository.save(user);
    }


    public User updatePassword(String username, String newPassword) {
        // Find the user by username
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new RuntimeException("User not found.");
        }

        // Update the password
        user.setPassword(newPassword);
        userRepository.save(user); // Save the updated user with the new password

        return user;
    }
}
